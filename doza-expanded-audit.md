# DozaAnimata expanded address audit

**50/50 additional title addresses passed on Android TV: 25 movies and 25 distinct series.** The previous 14 Doza cases also pass. Zero wrong-page matches. No streams were resolved.

## Method and scope

Recorded seed: 3950667988. The sample contains 50 distinct TMDB identities and none overlap the previous 14 cases. Titles came from dubbed-content archives. Three initially listed entries were replaced before resolver testing: one TV compilation filed as a movie, and two separate Bakugan season pages that are not distinct TMDB series. These exclusions remain recorded in the JSON report.

Main-article TMDB artwork, original titles, descriptions and cast were checked independently during fixture calibration. This corrected a same-year Scrooge short incorrectly selected by title search. The Dexter episode expectation was also corrected against TMDB season metadata: TMDB S2E10, The Koos is Loose, corresponds to Doza broadcast episode 4, segment 2. No failed resolver case was removed from the final 50.

## Fixes in version 4

- Use public original-title tag archives when ordinary WordPress search misses translated titles.
- Verify the current article’s structured TMDB artwork against the requested TMDB entry. Ignore recommendation images and unrelated image hosts.
- Keep release year checks. A publisher date difference additionally requires exact verified artwork, title overlap, and two independently named cast members.
- Recognize single-season episode URLs that omit the season number.
- Map segmented broadcast episodes only when the complete ordered season has the same count as TMDB and at least two independently matching episode-name anchors. Ambiguous or incomplete mappings are rejected.

Address matching does not establish playback availability or spoken audio. The dubbed-page declaration remains required, but this audit did not listen to or resolve any media. The sample does not guarantee every catalog entry will match. Native TV support and the total limit of three usable streams remain unchanged.

| # | Type | Title | Requested TMDB episode | Result | Address |
|---:|---|---|---|---|---|
| 1 | Movie | Cracovia Freestyle | — | Correct | [Page](https://www.dozaanimata.net/cracovia-freestyle-2023-dublat-in-romana/) |
| 2 | Movie | Snicii | — | Correct | [Page](https://www.dozaanimata.net/snicii-2025-dublat-in-romana/) |
| 3 | Movie | Cum să Ascunzi un Câine în New York | — | Correct | [Page](https://www.dozaanimata.net/cum-sa-ascunzi-un-caine-in-new-york-2004-dublat-in-romana/) |
| 4 | Movie | Scrooge: Poveste de Crăciun | — | Correct | [Page](https://www.dozaanimata.net/scrooge-poveste-de-craciun-2022-dublat-in-romana/) |
| 5 | Movie | Tom și Jerry: Pe Mustața Mea | — | Correct | [Page](https://www.dozaanimata.net/tom-si-jerry-pe-mustata-mea-2006-dublat-in-romana/) |
| 6 | Movie | Aventură în Natură 3: Marea Întrecere | — | Correct | [Page](https://www.dozaanimata.net/aventura-in-natura-3-marea-intrecere-2024-dublat-in-romana/) |
| 7 | Movie | Un Crăciun de Groază | — | Correct | [Page](https://www.dozaanimata.net/un-craciun-de-groaza-2012-dublat-in-romana/) |
| 8 | Movie | Patrula Cățelușilor: Salvare cu Reacție | — | Correct | [Page](https://www.dozaanimata.net/patrula-catelusilor-salvare-cu-reactie-2020-dublat-in-romana/) |
| 9 | Movie | Ne-am pierdut Omul | — | Correct | [Page](https://www.dozaanimata.net/ne-am-pierdut-omul-2023-dublat-in-romana/) |
| 10 | Movie | Dumbo | — | Correct | [Page](https://www.dozaanimata.net/dumbo-1941-dublat-in-romana/) |
| 11 | Movie | Cartea dragonilor | — | Correct | [Page](https://www.dozaanimata.net/cartea-dragonilor-2011-dublat-in-romana/) |
| 12 | Movie | Dog Man | — | Correct | [Page](https://www.dozaanimata.net/dog-man-2025-dublat-in-romana/) |
| 13 | Movie | Supermonstruleții Salvează Crăciunul | — | Correct | [Page](https://www.dozaanimata.net/supermonstruletii-salveaza-craciunul-2019-dublat-in-romana/) |
| 14 | Movie | Scooby-Doo în Nopțile Arabe | — | Correct | [Page](https://www.dozaanimata.net/scooby-doo-in-noptile-arabe-1994-dublat-in-romana/) |
| 15 | Movie | Dragoste la Pătrat pentru Totdeauna | — | Correct | [Page](https://www.dozaanimata.net/dragoste-la-patrat-pentru-totdeauna-2023-dublat-in-romana/) |
| 16 | Movie | Lista Moșului | — | Correct | [Page](https://www.dozaanimata.net/lista-mosului-2013-dublat-in-romana/) |
| 17 | Movie | Looney Looney Looney: Filmul lui Bugs Bunny | — | Correct | [Page](https://www.dozaanimata.net/looney-looney-looney-filmul-lui-bugs-bunny-1981-dublat-in-romana/) |
| 18 | Movie | Micul meu Ponei: Fetele Equestriei – Caruselul Prieteniei | — | Correct | [Page](https://www.dozaanimata.net/micul-meu-ponei-fetele-equestriei-caruselul-prieteniei-2018-dublat-in-romana/) |
| 19 | Movie | The Legend of Ochi | — | Correct | [Page](https://www.dozaanimata.net/the-legend-of-ochi-2025-dublat-in-romana/) |
| 20 | Movie | Lumea Miraculoasă: Tokyo Forța Stelară | — | Correct | [Page](https://www.dozaanimata.net/lumea-miraculoasa-tokyo-forta-stelara-2025-dublat-in-romana/) |
| 21 | Movie | Înapoi în Viitor | — | Correct | [Page](https://www.dozaanimata.net/inapoi-in-viitor-1985-dublat-in-romana/) |
| 22 | Movie | Scooby-Doo merge la Hollywood | — | Correct | [Page](https://www.dozaanimata.net/scooby-doo-merge-la-hollywood-1979-dublat-in-romana/) |
| 23 | Movie | Epoca de Gheață 4: Continente în Derivă | — | Correct | [Page](https://www.dozaanimata.net/epoca-de-gheata-4-continente-in-deriva-2012-dublat-in-romana/) |
| 24 | Movie | Îmblânzirea Scorpiei | — | Correct | [Page](https://www.dozaanimata.net/imblanzirea-scorpiei-2022-dublat-in-romana/) |
| 25 | Movie | Wallace și Gromit: Răzbunare Împănată | — | Correct | [Page](https://www.dozaanimata.net/wallace-si-gromit-razbunare-impanata-2024-dublat-in-romana/) |
| 26 | Series | Haideți Tineri Titani | S1 E4 | Correct | [Page](https://www.dozaanimata.net/episode/haideti-tineri-titani-sezonul-1-episodul-4-mana-de-caine/) |
| 27 | Series | Hero Inside | S2 E4 | Correct | [Page](https://www.dozaanimata.net/episode/hero-inside-sezonul-2-episodul-4-cel-bun-cel-rau-cel-jeleu/) |
| 28 | Series | Chop Socky Chooks | S1 E22 | Correct | [Page](https://www.dozaanimata.net/episode/chop-socky-chooks-sezonul-1-episodul-22-primire-de-gandaci/) |
| 29 | Series | Cronicile Xiaolin | S1 E23 | Correct | [Page](https://www.dozaanimata.net/episode/cronicile-xiaolin-sezonul-1-episodul-23-din-nou-in-carne-si-oase/) |
| 30 | Series | Minunata și Năstrușnica Lume a lui Gumball | S1 E18 | Correct | [Page](https://www.dozaanimata.net/episode/minunata-si-nastrusnica-lume-a-lui-gumball-sezonul-1-episodul-18-portretul/) |
| 31 | Series | Să-nceapă Aventura | S6 E22 | Correct | [Page](https://www.dozaanimata.net/episode/sa-nceapa-aventura-sezonul-6-episodul-22-racirea/) |
| 32 | Series | LEGO Monkie Kid | S3 E2 | Correct | [Page](https://www.dozaanimata.net/episode/lego-monkie-kid-sezonul-3-episodul-2-stra-dragonul-din-est/) |
| 33 | Series | Laboratorul lui Dexter | S2 E10 | Correct | [Page](https://www.dozaanimata.net/episode/laboratorul-lui-dexter-sezonul-2-episodul-4-2-koosy-in-libertate/) |
| 34 | Series | Turneul Mondial al Dramei Totale | S1 E2 | Correct | [Page](https://www.dozaanimata.net/episode/turneul-mondial-al-dramei-totale-sezonul-1-episodul-2-ca-un-egiptean-partea-ii/) |
| 35 | Series | Drama Totală: Insula Pacatel | S1 E3 | Correct | [Page](https://www.dozaanimata.net/episode/drama-totala-insula-pacatel-sezonul-1-episodul-3-familia-nu-e-totul/) |
| 36 | Series | Trenul Infinitului | S1 E4 | Correct | [Page](https://www.dozaanimata.net/episode/trenul-infinitului-sezonul-1-episodul-4-vagonul-de-cristal/) |
| 37 | Series | Steven Universe Future | S1 E1 | Correct | [Page](https://www.dozaanimata.net/episode/steven-universe-future-episodul-1-mica-scoala-de-acasa/) |
| 38 | Series | Jentry Chau Împotriva Infernului | S1 E6 | Correct | [Page](https://www.dozaanimata.net/episode/jentry-chau-impotriva-infernului-sezonul-1-episodul-6-in-dragoste-si-n-razboi/) |
| 39 | Series | Academia Unicornilor | S2 E10 | Correct | [Page](https://www.dozaanimata.net/episode/academia-unicornilor-sezonul-2-episodul-10-grimoria-reapare/) |
| 40 | Series | Minecraft: Modul Narativ | S1 E2 | Correct | [Page](https://www.dozaanimata.net/episode/minecraft-modul-narativ-sezonul-1-episodul-2-reunire-necesara/) |
| 41 | Series | Micul meu Ponei: Prietenia este Magică | S8 E9 | Correct | [Page](https://www.dozaanimata.net/episode/micul-meu-ponei-prietenia-este-magica-sezonul-8-episodul-9-competitia/) |
| 42 | Series | Armura de Jad | S1 E5 | Correct | [Page](https://www.dozaanimata.net/episode/armura-de-jad-sezonul-1-episodul-5-basticonul-rebel/) |
| 43 | Series | Jurassic World: Teoria Haosului | S2 E1 | Correct | [Page](https://www.dozaanimata.net/episode/jurassic-world-teoria-haosului-sezonul-2-episodul-1-asteapta-te-la-ce-e-mai-rau/) |
| 44 | Series | LEGO: Cavalerii Nexo | S1 E2 | Correct | [Page](https://www.dozaanimata.net/episode/lego-cavalerii-nexo-sezonul-1-episodul-2-cartea-monstrilor-partea-ii/) |
| 45 | Series | Looniversitatea Micuților | S1 E8 | Correct | [Page](https://www.dozaanimata.net/episode/looniversitatea-micutilor-sezonul-1-episodul-8-souffle-fata/) |
| 46 | Series | Ninjago: Ascensiunea Dragonilor | S3 E14 | Correct | [Page](https://www.dozaanimata.net/episode/ninjago-ascensiunea-dragonilor-sezonul-3-episodul-14-sicriul-cu-oase/) |
| 47 | Series | Regele Lup | S1 E3 | Correct | [Page](https://www.dozaanimata.net/episode/regele-lup-sezonul-1-episodul-3-fiara-in-cusca/) |
| 48 | Series | Voltron: Apărătorul Legendar | S2 E1 | Correct | [Page](https://www.dozaanimata.net/episode/voltron-aparatorul-legendar-sezonul-2-episodul-1-de-la-un-capat-la-altul-al-universului/) |
| 49 | Series | Scooby-Doo și Echipa Misterelor | S1 E17 | Correct | [Page](https://www.dozaanimata.net/episode/scooby-doo-si-echipa-misterelor-sezonul-1-episodul-17-evadarea-din-conacul-misterios/) |
| 50 | Series | Maya și cei Trei | S1 E3 | Correct | [Page](https://www.dozaanimata.net/episode/maya-si-cei-trei-sezonul-1-episodul-3-primul-luptator/) |

Original and test repositories were not modified.
