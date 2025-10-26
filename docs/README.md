| **English** | [Português(Brasil)](README.pt-BR.md)

# WaEnhancer
<div align="center">
  <p><strong>WaEnhancer is an Xposed module that enhances your WhatsApp experience.</p></strong>
  <p><strong>Warning:</strong> This module is intended for educational purposes only, you may have problems with your WhatsApp account, risk of banning! Use it at your own risk.</p>
  <p>Please note that this project is currently in development, so bugs and crashes may occur. If you encounter any issues report them in our group or create an <a href="https://github.com/Dev4Mod/WaEnhancer/issues">issue</a> here.</p>
</div>


## Main Features
<details closed>
  <summary>Privacy</summary>

- `Hide Forwarded Tag`
- `Remove Forward Limit`
- `Disable Pinned Chats Limit`
- `Freeze Last Seen`
- `Hide Status View`
- `Hide Blue Ticks`
- `Hide View Once and Audio Seen`
- `Hide Delivered`
- `Hide Typing`
- `Hide Recording Audio`
- `Disable View Once`
- `Send Blue Ticks upon Reply`
- `Delete for everyone on all messages`
- `Show Edited Message History`
- `Remove See More Button`
- `Anti Revoke Status`
- `Anti Revoke Message`
- `Anti Disappearing Messages`
- `Custom Privacy per Contact`
- `Ghost Mode`
- `Always Online`
- `Call Privacy & Blocking`
- `Call Information`
- `Call Contact Whitelist/Blocklist`
</details>

<details closed>
  <summary>Home Screen</summary>

- `Show Name`
- `Show Bio`
- `Show DND Button`
- `Separate Groups`
- `Hide Archived Chats`
- `Show Online Dot in Conversation List`
- `Remove Channel Recommendations`
- `Hide Tabs on Home`
- `Enable IGStatus on Home Screen`
- `Filter Chats`
- `Wallpaper in Home Screen`
- `Show Chat Broadcast Icon`
- `List Animations`
- `Disable Channels`
</details>  

<details closed>
  <summary>General</summary>

- `Time in 12-Hour Format`
- `Seconds on Timestamp`
- `Buttons Stroke`
- `Menu Icons`
- `Outlined Icons`
- `New Settings Style`
- `Theme Mode Selection`
- `Lite Mode`
- `Force English`
- `Bootloader Spoofer`
- `Tasker Automation`
- `Show Toast on Contact Online`
- `Toast on Message Delete`
- `Toast on Viewed Message`
- `Google Translate Integration`
- `Double Click to React`
- `Custom Reaction Emoji`
- `Disable Auto Status`
- `Enable Copy Status`
- `Toast on Viewed Status`
</details>

<details closed>
  <summary>Media</summary>

- `Download Status`
- `Download View Once`
- `HD Quality Videos`
- `HD Quality Images`
- `Send videos in 60FPS`
- `Send videos in original resolution`
- `Increased Video Size Limit`
- `Disable Audio Sensor (Proximity)`
- `Audio Transcription`
- `Voice Note Speed Control`
- `Send Audio as Voice/Audio Note`
- `Enable Media Preview`
- `Custom Download Location`

</details>

<details closed>
  <summary>Customization</summary>

- `Colors Customization`
   - `Primary Color`
   - `Secondary Color`
   - `Background Color`
- `Bubble Colors Customization`
   - `Left Bubble Color`
   - `Right Bubble Color`
- `Wallpaper & Transparency Settings`
- `Hide Tabs`
- `Custom Filters and Theme`
- `Custom CSS Themes`
- `Custom DPI`
- `Theme Manager`
- `Animation Emojis`
- `New Context Menu UI`
- `Show Admin Group Icon`
- `Menu with Icons`
- `Status Style Customization`
- `Old Statuses UI`
- `Custom Colors for Text Status`
</details>

<details closed>
  <summary>Others</summary>

- `Selection of Call Type`
- `Confirmation to Send Sticker`
- `Disable Default Emojis`
- `Stamp Copied Messages`
</details>

## Installation
1. Ensure that your device is rooted.
2. Install the Xposed Framework (recommend [this](https://github.com/JingMatrix/LSPosed) LPosed) on
   your device.
3. Download the WaEnhancer from the [Actions](https://github.com/Dev4Mod/WaEnhancer/actions) section.
4. Install the WaEnhancer APK.
5. Enable the WaEnhancer module in the Xposed Installer app.

## Building on Android with Termux
If you do not have access to a desktop environment you can build the module directly on your rooted
phone by using [Termux](https://f-droid.org/en/packages/com.termux/). The steps below download the
source code, compile the APK, and move it to shared storage so you can install it.

1. Install Termux from F-Droid (Google Play builds are outdated) and open the app.
2. Update the package index and install the required build tools:
   ```bash
   pkg update && pkg upgrade
   pkg install git openjdk-17 zip unzip wget
   ```
3. Grant Termux access to shared storage so you can copy the generated APK later:
   ```bash
   termux-setup-storage
   ```
4. Clone your fork (or this repository) and enter the project directory:
   ```bash
   git clone https://github.com/Dev4Mod/WaEnhancer.git
   cd WaEnhancer
   ```
5. Ensure the Gradle wrapper is executable and start the release build:
   ```bash
   chmod +x gradlew
   ./gradlew assembleRelease

   > ℹ️  If your environment blocks outbound HTTPS downloads (common on
   > corporate proxies or sandboxed CI runners), opt into the system-wide
   > Gradle installation by prefixing the command with
   > `GRADLEW_USE_SYSTEM=true`. The wrapper script will then execute the
   > locally installed `gradle` binary instead of attempting to fetch a new
   > distribution:
   >
   > ```bash
   > GRADLEW_USE_SYSTEM=true ./gradlew assembleRelease
   > ```
   ```
   The download of Gradle and the Android build tools can take several minutes on first run. If the
   process is killed due to low memory, close other apps and rerun the command.
6. Copy the generated APK to the shared downloads folder and install it:
   ```bash
   cp app/build/outputs/apk/release/app-release.apk ~/storage/downloads/WaEnhancer-release.apk
   ```
   You can now install the APK via the Android file manager or with `pm install --user 0
   ~/storage/downloads/WaEnhancer-release.apk` from Termux.

After the module is installed, enable it inside LSPosed/EdXposed and reboot your device so the hooks
are applied.

## Support
If you encounter any issues or have questions about WaEnhancer, please [Visit Telegram](https://t.me/waenhancer).

## License
This project is licensed under the GNU License - see the [LICENSE](LICENSE) file for details.

## Thanks

* Bootloader Spoofer (Thanks to [chiteroman](https://github.com/chiteroman))
* LSPosed Framework Core Patch (thanks to the [LSPosed](https://github.com/LSPosed) team)
* Bridge Client and Server (Thanks to [rhunk](https://github.com/rhunk/))

---

**Note**: Please use WaEnhancer responsibly and in compliance with the terms and conditions of the apps you are modifying. Misuse of this tool may lead to legal consequences.
