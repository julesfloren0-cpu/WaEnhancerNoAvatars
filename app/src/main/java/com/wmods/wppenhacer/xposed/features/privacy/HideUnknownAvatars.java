package com.wmods.wppenhacer.xposed.features.privacy;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.wmods.wppenhacer.xposed.core.Feature;
import com.wmods.wppenhacer.xposed.core.WppCore;
import com.wmods.wppenhacer.xposed.core.devkit.Unobfuscator;
import com.wmods.wppenhacer.xposed.utils.DesignUtils;
import com.wmods.wppenhacer.xposed.utils.ReflectionUtils;
import com.wmods.wppenhacer.xposed.utils.Utils;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;

public class HideUnknownAvatars extends Feature {

    private final int contactSelectorId = Utils.getID("contact_selector", "id");

    public HideUnknownAvatars(@NonNull ClassLoader loader, @NonNull XSharedPreferences preferences) {
        super(loader, preferences);
    }

    @Override
    public void doHook() throws Throwable {
        var onChangeStatus = Unobfuscator.loadOnChangeStatus(classLoader);
        var field1 = Unobfuscator.loadViewHolderField1(classLoader);
        var absViewHolderClass = Unobfuscator.loadAbsViewHolder(classLoader);
        field1.setAccessible(true);
        var viewField = ReflectionUtils.findFieldUsingFilter(absViewHolderClass, field -> field.getType() == View.class);
        if (viewField == null) return;
        viewField.setAccessible(true);
        var jidClass = XposedHelpers.findClass("com.whatsapp.jid.Jid", classLoader);

        XposedBridge.hookMethod(onChangeStatus, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                if (!prefs.getBoolean("block_unknown_avatars", false)) return;

                var viewHolder = field1.get(param.thisObject);
                if (viewHolder == null) return;

                var rootView = (View) viewField.get(viewHolder);
                if (rootView == null) return;

                var data = param.args.length > 0 ? param.args[0] : null;
                if (data == null) return;

                var jidField = ReflectionUtils.getFieldByExtendType(data.getClass(), jidClass);
                if (jidField == null) return;

                var jidObject = jidField.get(data);
                var rawJid = WppCore.getRawString(jidObject);
                if (TextUtils.isEmpty(rawJid) || WppCore.isGroup(rawJid)) return;

                var savedName = WppCore.getSContactName(jidObject, true);
                if (!TextUtils.isEmpty(savedName)) return;

                var avatarView = findAvatarView(rootView);
                if (avatarView == null) return;

                var placeholder = DesignUtils.getDrawableByName("avatar_contact");
                if (placeholder != null) {
                    avatarView.setImageDrawable(placeholder);
                }
            }
        });
    }

    private ImageView findAvatarView(View root) {
        if (root == null) return null;
        View container = null;
        if (contactSelectorId != -1) {
            container = root.findViewById(contactSelectorId);
        }
        if (container instanceof ImageView imageView) {
            return imageView;
        } else if (container instanceof ViewGroup viewGroup) {
            var result = findFirstImageView(viewGroup);
            if (result != null) return result;
        } else if (container != null) {
            var result = findFirstImageView(container);
            if (result != null) return result;
        }
        return findFirstImageView(root);
    }

    private ImageView findFirstImageView(View view) {
        if (view instanceof ImageView) {
            return (ImageView) view;
        }
        if (view instanceof ViewGroup group) {
            for (int i = 0; i < group.getChildCount(); i++) {
                var childResult = findFirstImageView(group.getChildAt(i));
                if (childResult != null) {
                    return childResult;
                }
            }
        }
        return null;
    }

    @NonNull
    @Override
    public String getPluginName() {
        return "HideUnknownAvatars";
    }
}

