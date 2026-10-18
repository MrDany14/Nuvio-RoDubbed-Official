# DeseneFaine address matching — version 3

**Final Android result: 50/50 correct, zero wrong-title matches.** The previous official version scored 41/50 on the same sample: eight misses and one wrong-series match. The 14 Doza cases also pass.

## Changes

- Match a series parent by its own primary/original title and premiere year, then follow that parent’s exact episode link. Episode air dates may differ from the series premiere year.
- Recognize long Romanian season/episode paths, `s1-ep1`, and `1x1`. Validate the canonical episode number too.
- Limit identity metadata to the main article/header; recommendations cannot provide a missing title or year.
- Use English TMDB metadata when the Romanian/original names do not locate a page.
- Accept a short original movie name only when the publisher uses that exact slug, the heading extends it with a colon subtitle, and the release year matches.

Dinozaurii (2026) now resolves to the documentary’s `dinozaurii-1x1` page rather than the 1991 comedy. Ozzy and the seven previously missed series now match their recorded expected pages. No title-specific mappings were hard-coded.

## Verification

The same randomized sample of 25 movies and 25 distinct series was retained. Each series case checks an exact season and episode. No stream hosts or media were requested in these audits. Existing host protocols, Romanian-audio gates and the three-source limit remain unchanged. A correct catalog address does not establish stream availability or audio language.

| # | Type | Title | Episode | Correct address | Android time |
|---:|---|---|---|---|---:|
| 1 | Movie | Kung Fu Panda 4 | — | [Correct](https://desenefaine.com/film/kung-fu-panda-4/) | 264 ms |
| 2 | Movie | Fantome singuratice | — | [Correct](https://desenefaine.com/film/fantome-singuratice/) | 572 ms |
| 3 | Movie | Misiune: Imposibilă – Răfuială finală | — | [Correct](https://desenefaine.com/film/misiune-imposibila-rafuiala-finala/) | 195 ms |
| 4 | Movie | Iepurele-Găină și Hamsterul Întunericului | — | [Correct](https://desenefaine.com/film/iepurele-gaina-si-hamsterul-intunericului/) | 198 ms |
| 5 | Movie | Jocul terorii | — | [Correct](https://desenefaine.com/film/jocul-terorii/) | 171 ms |
| 6 | Movie | Batman and Superman: Battle of the Super Sons | — | [Correct](https://desenefaine.com/film/batman-and-superman-battle-of-the-super-sons/) | 310 ms |
| 7 | Movie | Domnița | — | [Correct](https://desenefaine.com/film/domnita/) | 211 ms |
| 8 | Movie | Dincolo de Lună | — | [Correct](https://desenefaine.com/film/dincolo-de-luna/) | 172 ms |
| 9 | Movie | Highlander: Endgame | — | [Correct](https://desenefaine.com/film/highlander-runda-finala/) | 176 ms |
| 10 | Movie | Balto | — | [Correct](https://desenefaine.com/film/balto/) | 166 ms |
| 11 | Movie | Monstrul din camera mea | — | [Correct](https://desenefaine.com/film/monstrul-din-camera-mea/) | 151 ms |
| 12 | Movie | Scooby Doo si monstrul de pe Luna | — | [Correct](https://desenefaine.com/film/scooby-doo-si-monstrul-de-pe-luna/) | 296 ms |
| 13 | Movie | The Book of Eli | — | [Correct](https://desenefaine.com/film/the-book-of-eli/) | 287 ms |
| 14 | Movie | Pinocchio | — | [Correct](https://desenefaine.com/film/pinocchio/) | 168 ms |
| 15 | Movie | Scooby-Doo! Ii Intalneste Pe Fratii Boo | — | [Correct](https://desenefaine.com/film/scooby-doo-ii-intalneste-pe-fratii-boo/) | 514 ms |
| 16 | Movie | Tocilarul fermecător | — | [Correct](https://desenefaine.com/film/tocilarul-fermecator/) | 174 ms |
| 17 | Movie | Libertate | — | [Correct](https://desenefaine.com/film/libertate/) | 179 ms |
| 18 | Movie | Ozzy: Marea Evadare | — | [Correct](https://desenefaine.com/film/ozzy/) | 169 ms |
| 19 | Movie | Lego Regatul de Gheață: Operațiunea Pufini | — | [Correct](https://desenefaine.com/film/lego-regatul-de-gheata-operatiunea-pufini/) | 172 ms |
| 20 | Movie | Barbie în povestea unei sirene | — | [Correct](https://desenefaine.com/film/barbie-in-povestea-unei-sirene/) | 145 ms |
| 21 | Movie | Ruby Gillman, adolescenta kraken | — | [Correct](https://desenefaine.com/film/ruby-gillman-adolescenta-kraken/) | 189 ms |
| 22 | Movie | Tom și Jerry: O aventură gigantică | — | [Correct](https://desenefaine.com/film/tom-si-jerry-o-aventura-gigantica/) | 561 ms |
| 23 | Movie | 100 Meters | — | [Correct](https://desenefaine.com/film/100-meters/) | 183 ms |
| 24 | Movie | Mașini 2 | — | [Correct](https://desenefaine.com/film/masini-2/) | 189 ms |
| 25 | Movie | The Crow: Iubire și răzbunare | — | [Correct](https://desenefaine.com/film/the-crow-iubire-si-razbunare/) | 146 ms |
| 26 | Series | LEGO Războiul Stelelor: Reconstrucția galaxiei | S1 E1 | [Correct](https://desenefaine.com/epi/lego-razboiul-stelelor-reconstructia-galaxiei-sezonul-1-episodul-1/) | 320 ms |
| 27 | Series | Dinozaurii | S1 E1 | [Correct](https://desenefaine.com/epi/dinozaurii-1x1/) | 905 ms |
| 28 | Series | Echipa Mighty Ducks: Sezonul Schimbărilor | S2 E5 | [Correct](https://desenefaine.com/epi/echipa-mighty-ducks-sezonul-schimbarilor-sezonul-2-episodul-5/) | 382 ms |
| 29 | Series | Micile Genii | S2 E28 | [Correct](https://desenefaine.com/epi/micile-genii-sezonul-2-episodul-28/) | 849 ms |
| 30 | Series | X-Men: Evoluție | S3 E10 | [Correct](https://desenefaine.com/epi/x-men-evolutie-sezonul-3-episodul-10/) | 1189 ms |
| 31 | Series | Tinerii justițiari | S3 E18 | [Correct](https://desenefaine.com/epi/tinerii-justitiari-sezonul-3-episodul-18/) | 802 ms |
| 32 | Series | Miraculous: Buburuza și Motan Noir | S1 E4 | [Correct](https://desenefaine.com/epi/miraculous-buburuza-si-motan-noir-s1-ep4/) | 584 ms |
| 33 | Series | Strada Dalmațieni 101 | S1 E15 | [Correct](https://desenefaine.com/epi/strada-dalmatieni-101-s1-ep15/) | 396 ms |
| 34 | Series | The Acolyte | S1 E4 | [Correct](https://desenefaine.com/epi/the-acolyte-sezonul-1-episodul-4/) | 322 ms |
| 35 | Series | Kizazi Moto: Generația de Foc | S1 E3 | [Correct](https://desenefaine.com/epi/kizazi-moto-generatia-de-foc-s1-ep3/) | 373 ms |
| 36 | Series | O poveste grimminală | S1 E6 | [Correct](https://desenefaine.com/epi/o-poveste-grimminala-s1-ep6/) | 699 ms |
| 37 | Series | OK, K.O.! Să fim eroi! | S3 E8 | [Correct](https://desenefaine.com/epi/ok-k-o-sa-fim-eroi-sezonul-3-episodul-8/) | 1031 ms |
| 38 | Series | Mira, detectiv regal | S2 E21 | [Correct](https://desenefaine.com/epi/mira-detectiv-regal-sezonul-2-episodul-21/) | 623 ms |
| 39 | Series | Moon Knight | S1 E3 | [Correct](https://desenefaine.com/epi/moon-knight-s1-ep3/) | 323 ms |
| 40 | Series | Vampire in the Garden | S1 E1 | [Correct](https://desenefaine.com/epi/vampire-in-the-garden-s1-ep1/) | 763 ms |
| 41 | Series | Aventurile lui Spider-Man | S2 E3 | [Correct](https://desenefaine.com/epi/aventurile-lui-spider-man-s2-ep3/) | 1096 ms |
| 42 | Series | Jocul calamarului | S2 E6 | [Correct](https://desenefaine.com/epi/jocul-calamarului-sezonul-2-episodul-6/) | 404 ms |
| 43 | Series | Terminator Zero | S1 E1 | [Correct](https://desenefaine.com/epi/terminator-zero-sezonul-1-episodul-1/) | 377 ms |
| 44 | Series | Futurama | S4 E6 | [Correct](https://desenefaine.com/epi/futurama-sezonul-4-episodul-6/) | 787 ms |
| 45 | Series | Academia eroilor | S2 E1 | [Correct](https://desenefaine.com/epi/academia-eroilor-sezonul-2-episodul-1/) | 444 ms |
| 46 | Series | Animals Up Close with Bertie Gregory | S1 E4 | [Correct](https://desenefaine.com/epi/animals-up-close-with-bertie-gregory-s1-ep4/) | 512 ms |
| 47 | Series | Bugs Bunny Constructorii | S2 E13 | [Correct](https://desenefaine.com/epi/bugs-bunny-constructorii-sezonul-2-episodul-13/) | 1115 ms |
| 48 | Series | Doctor Who | S2 E5 | [Correct](https://desenefaine.com/epi/doctor-who-sezonul-2-episodul-5/) | 459 ms |
| 49 | Series | She-Hulk: Avocata apărării | S1 E8 | [Correct](https://desenefaine.com/epi/she-hulk-avocata-apararii-s1-ep8/) | 419 ms |
| 50 | Series | SpongeBob Pantaloni Pătrați | S11 E12 | [Correct](https://desenefaine.com/epi/spongebob-pantaloni-patrati-sezonul-11-episodul-12/) | 1482 ms |

The original and test repositories are unchanged. Netu and Playmogo remain deferred.
