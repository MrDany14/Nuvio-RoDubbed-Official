# RoDubbed

Romanian dubbed streams for **Nuvio TV**, running entirely on the Android TV device. One provider combines Byse, SeekStreaming, StreamP2P and VOE from DeseneFaine, plus Vidmoly from DozaAnimata and Byse/Streamtape from FilmeDublate. No PC or helper server is needed.

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
- Checks HLS playlists and an initial media segment; Streamtape MP4 links require a full-length duration matching the title page before returning a stream. Publisher labels cannot guarantee the spoken language or every device's decoding compatibility.
- Netu and Playmogo/DoodStream are deferred and excluded. Player4me is not supported. DeseneleDublate is paused and not included. Abyss and morencius are not implemented.

## Version 5: FilmeDublate

Adds FilmeDublate Byse and Streamtape as a fallback when existing sites return fewer than three results. The provider still returns at most three distinct streams. Streamtape is enabled only with FilmeDublate provenance; an English-only copy tested on another site remains excluded.

**Twenty title/episode addresses passed 20/20 on Android**, including fifteen movies and five distinct series with requested episodes. No hosts were requested during that audit. Four other catalog entries remain unverified because independent TMDB mapping failed. See the [twenty-title report](filmedublate-audit.md). Separate media checks passed eight links across six cases; Mario Streamtape was rejected for runtime disagreement. The user confirms Toy Story5 Byse and Streamtape play on physical TV in the isolated FD build. Exact combined v5 physical playback is pending.

Abyss, morencius, Netu and Sendvid remain excluded. The original repository and all test folders are unchanged.

## Version 4: DozaAnimata address fixes

A further **25 movies and 25 distinct series passed 50/50 address checks on Android TV**, with no overlap with the earlier Doza sample. The previous 14 Doza cases also pass. Original-title tags, verified article artwork, legacy episode URLs and guarded broadcast-segment mapping improve title discovery. No streams were resolved in this audit. See the [50-title Doza report](doza-expanded-audit.md).

## Expanded verification

A further **50 movies and 50 distinct series** passed Android address checks: 99 exact/canonical matches and 1 verified duplicate page. None overlap the previous 50. The earlier 50 DeseneFaine cases and 14 Doza cases also pass. Legacy URL spellings and independently verified premiere-year differences are now handled. See the [100-title report](desenefaine-expanded-audit.md). No streams were resolved during these audits.

## Version 3: DeseneFaine address fixes

The unchanged 50-title DeseneFaine sample now passes **50/50 on Android**, up from 41/50; the 14 Doza address cases also pass. Series are located through a verified parent title and premiere year before selecting the requested episode, including `1x1` paths. English-title fallback and guarded movie aliases handle translation differences. See the [complete fifty-title audit](desenefaine-audit.md). No streams were resolved during these audits.

## Version 2: DozaAnimata

DozaAnimata is searched when DeseneFaine returns fewer than three results; the total limit remains three. Dubbed series are matched to their exact season and episode. Subtitled-only titles are excluded. When TMDB and the website use different translations, bounded public sitemap discovery and the main artwork's original-title filename supplement title matching, with release year and content type still required. This runs entirely on the TV and caches the catalog sitemap in memory for up to an hour.

A randomized sample of **seven movies and seven series episodes passed 14/14 address checks on Android** after fixing six translation-related misses. No stream host was requested or resolved during this audit. This sample supports the tested cases; it is not a guarantee that every catalog title will match. See [the full audit](catalog-audit.md).

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
