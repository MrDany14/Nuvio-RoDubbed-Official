# RoDubbed

Romanian dubbed streams for **Nuvio TV**, running entirely on the Android TV device. One provider combines Byse, SeekStreaming, StreamP2P and VOE from DeseneFaine. No PC or helper server is needed.

## Install on Nuvio TV

Add this repository URL in the TV application's plugin settings:

```text
https://raw.githubusercontent.com/MrDany14/Nuvio-RoDubbed-Official/main/repo.json
```

Enable **RoDubbed**. To avoid duplicate results, disable the older RoDubbed/test providers while using this one; keep them installed if you want a fallback. Existing original and test repositories are separate and remain available.

This is a native Android extension, tested against Nuvio TV 1.0.0. The mobile application's JavaScript plugin installer is not supported by this package.

## Sources and language

- Returns up to three distinct validated streams, preferring different hosts. A title with one available stream returns one.
- Discovers the title's available servers once, then resolves only relevant supported hosts. Legacy Filemoon labels can lead to Byse.
- Requires Romanian server declarations. For older bare host labels, accepts the title page's explicit Romanian-dubbing declaration. English/subtitled labels are excluded, and explicit foreign default audio in host/HLS metadata is rejected.
- Checks the playlist and an initial media segment before returning a stream. Publisher labels cannot guarantee the spoken language or every device's decoding compatibility.
- Netu is deferred and excluded from this release. Player4me is not supported. DeseneleDublate and DozaAnimata integration is planned, not included.

## Validation

The release was tested on Android ART using the actual official Nuvio TV 1.0.0 APK classes. Avatar returned VOE + Byse, Toy Story 5 returned Byse + SeekStreaming + StreamP2P, and Aventura tenisilor returned Byse only; unavailable hosts were excluded. Playlist and initial media checks passed. This is resolver/API integration testing, not installed-app playback testing of this exact combined release on a physical TV. The user previously confirmed physical TV playback for native Byse and the older SeekStreaming/StreamP2P providers, and confirmed Avatar's VOE source has Romanian audio.

See `validation.json` for the artifact checksum and timings.

## Build

Requires Node.js and a JDK with Java 8 output support. Dependency downloads are pinned and checksum-verified:

```text
node src/prepare.cjs
node src/build.cjs "C:/Program Files/Android/Android Studio/jbr/bin"
```

The build copies `RoDubbed.cs3` to the repository root. Compile-only API stubs and downloaded dependency JARs are never bundled in the extension. `UnifiedUnitTest.java`, `UnifiedSmokeTest.java` and `VoeSmokeTest.java` are test harnesses and are excluded from the extension.
