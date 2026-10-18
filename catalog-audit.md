# DozaAnimata address audit

Randomized sample from 68 dubbed movies and 30 dubbed series on three public catalog archive pages; existing two development series excluded. Real TMDB model inputs, independent website title/year/episode expectations. No stream hosts requested or resolved.

Seed: `784801863`. Initial result: 8/14; final Android result: **14/14**. The same sample was retained while fixing discovery.

The fixes separate address location from host availability, use exact release year/content type, and fall back to bounded sitemap candidates plus original-title artwork identity when translations differ. English/subtitled content and unrelated recommendations remain excluded.

| Type | Title | Episode | Address | Android time |
|---|---|---|---|---|
| Movie | Crăciunul Angelei | — | [Correct page](https://www.dozaanimata.net/craciunul-angelei-2017-dublat-in-romana/) | 442 ms |
| Movie | Din mintea lui Jimmy: Filmul | — | [Correct page](https://www.dozaanimata.net/din-mintea-lui-jimmy-filmul-2006-dublat-in-romana/) | 1396 ms |
| Movie | Școala de Sperieturi a lui Casper | — | [Correct page](https://www.dozaanimata.net/scoala-de-sperieturi-a-lui-casper-2006-dublat-in-romana/) | 641 ms |
| Movie | Cursa Grand Prix a Europei | — | [Correct page](https://www.dozaanimata.net/cursa-grand-prix-a-europei-2025-dublat-in-romana/) | 601 ms |
| Movie | Ostatica Eloá: În direct la Televizor | — | [Correct page](https://www.dozaanimata.net/ostatica-eloa-in-direct-la-televizor-2025-dublat-in-romana/) | 735 ms |
| Movie | Craig Înainte de Dumbravă | — | [Correct page](https://www.dozaanimata.net/craig-inainte-de-dumbrava-2023-dublat-in-romana/) | 330 ms |
| Movie | Scooby-Doo! și Krypto Câinele Erou | — | [Correct page](https://www.dozaanimata.net/scooby-doo-si-krypto-cainele-erou-2023-dublat-in-romana/) | 783 ms |
| Series | Nașii Mei Vrăjitori: O Nouă Dorință | S1 E2 | [Correct page](https://www.dozaanimata.net/episode/nasii-mei-vrajitori-o-noua-dorinta-sezonul-1-episodul-2-scoala-de-corectie-magica-prietena-invatatoarei/) | 832 ms |
| Series | Iwaju: Orașul Viitorului | S1 E1 | [Correct page](https://www.dozaanimata.net/episode/iwaju-orasul-viitorului-sezonul-1-episodul-1-iwaju/) | 505 ms |
| Series | Lumea Looney Tunes | S1 E28 | [Correct page](https://www.dozaanimata.net/episode/lumea-looney-tunes-sezonul-1-episodul-28/) | 837 ms |
| Series | Fetițele Powerpuff | S2 E3 | [Correct page](https://www.dozaanimata.net/episode/fetitele-powerpuff-sezonul-2-episodul-3-la-multi-ani-nu-mai-am-chef/) | 921 ms |
| Series | Ultima Bârfă | S1 E2 | [Correct page](https://www.dozaanimata.net/episode/ultima-barfa-sezonul-1-episodul-2-dansul-locco-locco/) | 902 ms |
| Series | Barbie Mysteries: Goana după Cai | S1 E1 | [Correct page](https://www.dozaanimata.net/episode/barbie-mysteries-goana-dupa-cai-sezonul-1-episodul-1-atentie-la-neatentie/) | 610 ms |
| Series | Clasa lui 3000 | S1 E10 | [Correct page](https://www.dozaanimata.net/episode/clasa-lui-3000-sezonul-1-episodul-10-iubirea-e-in-aer/) | 740 ms |

No playback or media requests were part of this audit. Host protocols were already validated in the preceding official/test builds and confirmed on the user’s physical TV. Netu and Playmogo remain excluded.
