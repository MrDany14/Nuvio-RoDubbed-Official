# RoDubbed

Romanian dubbed streams for **Nuvio TV**, running entirely on the Android TV device. One provider combines Byse, SeekStreaming, StreamP2P and VOE from DeseneFaine, plus Vidmoly/Playmogo from DozaAnimata and Byse/Streamtape/Abyss from FilmeDublate. No PC or helper server is needed.

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
- Checks HLS playlists and an initial media segment; Streamtape and Abyss MP4 links require a full-length duration matching the title page before returning a stream. Publisher labels cannot guarantee the spoken language or every device's decoding compatibility.
- Playmogo.com and six verified Dood mirror domains are recognized on DozaAnimata. Netu, Sendvid, dsvplay.com and other unverified mirrors remain excluded. Player4me is not supported. DeseneleDublate is paused and not included. Morencius is not implemented. Abyss is enabled for FilmeDublate.

## Version 9: Verified series and season matching

Improves Doza matching through independent metadata rather than hardcoded title URLs. A series dated by its pilot year requires an exact primary-article IMDb identity, matching title and independently verified pilot date. Newly accepted episodes must match the requested episode name or exact episode IMDb identity.

A separately published Season1 page can represent a later TMDB season only when its release year, series/cast evidence and **every episode name in the complete season** agree. The verified publisher/TMDB numbering pair also reaches the player guard: Ninjago Island is publisherS1 but TMDBS14, and its upload usesS14. Other season/episode combinations remain rejected.

**13 Ninjago addresses pass**, including all four Island episodes. The prior14 Doza cases still pass; the recent60-title sample improves from49 to51 correct, with6misses and3unverified cases remaining and no confirmed new wrong matches. The existing duplicate movie address is still verified as the same film. Both Playmogo and Vidmoly resolve on the two supplied Ninjago pages; both Playmogo videos decoded distinct frames, and Island passed actual muted Android MediaPlayer playback and seeking. See [matching validation](doza-matching-validation.json).

The rules are reusable, but this audit establishes two newly fixed titles, not a universal solution. Croods/Bakugan and other flattening/split-episode patterns still need separate work. Some later Ninjago seasons are differently numbered and remain excluded when episode identity cannot be established. Physical Mi Box validation of exactv9 is pending.

## Version 8: Dood mirrors on DozaAnimata

Recognizes **d000d.com, dood.li, do0od.com, doods.pro, d0o0d.com and ds2play.com** through their verified Playmogo redirects. The resolver preserves the exact video ID and accepts only known HTTPS player destinations; it never invents a replacement ID. Requests retain the shared pool, deadlines and cancellation. The total remains up to three streams.

Of20 mirror links from the recent sample, **three were available, fifteen were removed and two failed DNS**. The available Disenchanted, Woody Goes to Camp and ThunderCats episode links passed exact-address checks, full-length MP4 metadata and two distinct decoded frames. Disenchanted (d000d.com) and ThunderCats (dood.li) passed native Android MediaPlayer playback and completed seeking. All15 removed uploads were rejected without returning streams, in about0.1–0.3seconds each. dsvplay.com remains excluded.

The three existing direct Playmogo examples still decode; both Doza hosts, subtitled-title exclusion and ToyStory5's three original hosts pass with the final artifact. These are emulator tests, not physical Mi Box verification or independent language listening. See [mirror validation](dood-mirrors-validation.json). Title-matching/Ninjago fixes are not included in this release.

## Version 7: Playmogo on DozaAnimata

Adds Playmogo.com alongside Vidmoly on DozaAnimata. The supplied **Miraculos S1E1** page now supports both servers. The new native resolver uses Nuvio's existing Android HTTP client and the public player handshake; it needs no browser, ad execution, desktop cookies or helper server. Links require actual MP4 data and must not be short error clips. Per-source playback headers are preserved. Requests share a connection pool and stop with the provider deadline/cancellation.

The exact episode address, Playmogo link and two distinct video frames passed for **Miraculos, Wednesday and Regular Show: The Lost Tapes**. Actual muted Android MediaPlayer playback and seeking passed for Miraculos and Wednesday; Miraculos was verified again with the final combined release. Both Miraculos hosts resolve with native VIDEO/M3U8 types. **All14 earlier Doza address cases still pass.** See [Playmogo validation](playmogo-validation.json). Physical Mi Box playback of this exact release remains pending.

Doza spells Miraculos differently from TMDB's Miraculous. A narrowly guarded one-letter spelling match now handles that case while requiring a matching premiere year and corroborating primary artwork. Other Dood mirror domains are not enabled. The total remains up to three streams.

## Version 6: Native Abyss

Adds the public Abyss player's native H.264 MP4 flow for FilmeDublate. It runs locally on Android, without executing player/ad scripts or using a helper server. Native playback receives Abyss-specific headers. MP4 duration must match the verified title page, and a bounded mid-file range request must succeed before a link is returned. The existing total limit remains three streams.

**Five of six sampled Abyss titles resolve; the sixth is correctly rejected for a runtime mismatch.** Four samples decoded different video frames at30s and60s on Android. ToyStory5, Ironheart S1E2 and Iubire la birou also passed actual muted Android MediaPlayer playback and seek-completion checks using the exact native Nuvio URL and headers. This is emulator/API testing, not physical Mi Box playback of this exact release. See [Abyss validation](abyss-validation.json).

The user confirmed ToyStory5 website audio is Romanian. Spoken audio in the other samples has not been listened to. Iubire la birou had slow/variable network behavior during checks; its720p copy subsequently decoded distinct frames. Network failures remain possible and skip the affected host.

## Version 5: FilmeDublate

Adds FilmeDublate Byse and Streamtape as a fallback when existing sites return fewer than three results. The provider still returns at most three distinct streams. Streamtape is enabled only with FilmeDublate provenance; an English-only copy tested on another site remains excluded.

**Twenty title/episode addresses passed 20/20 on Android**, including fifteen movies and five distinct series with requested episodes. No hosts were requested during that audit. Four other catalog entries remain unverified because independent TMDB mapping failed. See the [twenty-title report](filmedublate-audit.md). Separate media checks passed eight links across six cases; Mario Streamtape was rejected for runtime disagreement. The user confirms Toy Story5 Byse and Streamtape play on physical TV in the isolated FD build. Exact combined v5 physical playback is pending.

In version5, Abyss was not yet implemented. Morencius, Netu and Sendvid remain excluded. The original repository and all test folders are unchanged.

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
