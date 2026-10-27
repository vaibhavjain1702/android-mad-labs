# Android MAD Labs

Ten small Android (Java, Gradle Kotlin DSL) lab apps from a Mobile Application Development course. Each folder is a standalone Android Studio project.

| Folder | What it demonstrates |
|---|---|
| `lab1-first-app` | First Android app (package `com.example.a1`) |
| `CallMate` | Broadcast receiver for incoming phone calls |
| `EmailApp` | Composing an email via intents |
| `ImageCap` | Capturing an image with the camera |
| `MusicPlayer` | Audio playback with `MediaPlayer` |
| `notifications` | Notifications and an SMS receiver |
| `SettingsUI` | Settings screen UI |
| `SMSMessenger` | Sending and receiving SMS |
| `VideoPlayer` | Video playback with `VideoView` |
| `VideoRecorder` | Recording video |

## Build

Open a folder in Android Studio and sync Gradle (a `local.properties` with your SDK path is created automatically), or run `./gradlew assembleDebug` inside the folder. Several apps need runtime permissions (SMS, camera, phone state, storage) which must be granted on the device/emulator.

## Notes

- `MusicPlayer` expects an audio file at `app/src/main/res/raw/sample_music.mp3`, which is not included. Add any MP3 with that name before building.
- `VideoPlayer` includes a small sample video under `app/src/main/res/raw/`.
- `SettingsUI` contains a placeholder package declaration (`com.yourpackage.yourapp`) that should be adjusted to match the module's namespace if you hit a build error.

## Report

- [Graded Assignment report (PDF)](docs/GA_CSE5_230697_Vaibhav_Jain.pdf)
