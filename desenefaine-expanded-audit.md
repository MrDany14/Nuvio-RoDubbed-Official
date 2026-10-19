# DeseneFaine expanded address audit

**100/100 new titles matched on Android: 50 movies and 50 series.** The previous 50 DeseneFaine cases and 14 Doza cases also pass. No streams were resolved.

## Sample and method

Recorded seed: 3801692861. All 100 TMDB identities are distinct and none overlap the previous 50. Titles were selected from the public movie/series sitemaps. One separately listed Elena Shorts collection reused the main show’s TMDB identity; it was recorded as ineligible and replaced before the audit, not after a lookup failure.

Real TMDB title/year inputs were checked against independent website pages and exact episode addresses. One pair of duplicate movie posts identifies the same A Fairly Odd Christmas film, with identical TMDB artwork, original title, director and cast; either page is valid. Final result: 99 exact/canonical matches and 1 verified equivalent page, zero wrong-title matches.

One selected Me & Mickey page bundles episodes 1–40. The audit checks its listed S1E1 address; it does not claim that separate per-episode playback URLs exist.

## Additional fixes

- Recognize legacy `sezonul1-episoul1` spellings while keeping exact season/episode checks.
- Handle publisher premiere-year differences only with title/type identity and exact main artwork from the requested TMDB entry. The alternate date must be documented in TMDB release/season data or be an adjacent pilot-year difference. A date difference alone cannot admit a remake.
- Keep a Shorts collection from replacing a full series when the metadata is reused.

The first pass had 94 exact matches plus the verified duplicate (95 correct titles), with 5 misses. The same 100 cases passed after the fixes. The 14 Doza regressions and the earlier 50 DeseneFaine cases also pass. This sample does not guarantee every title in the full catalog. Catalog matching does not establish audio language or playback availability.

| # | Type | Title | Episode | Result | Located address |
|---:|---|---|---|---|---|
| 1 | Movie | Clifford, Marele Câine Roșu | — | Correct | [Page](https://desenefaine.com/film/clifford-marele-caine-rosu/) |
| 2 | Movie | Bucătarul Donald | — | Correct | [Page](https://desenefaine.com/film/bucatarul-donald/) |
| 3 | Movie | Patrula junglei: Operațiunea Banquise | — | Correct | [Page](https://desenefaine.com/film/patrula-junglei-operatiunea-banquise/) |
| 4 | Movie | Călătorie în țara ta | — | Correct | [Page](https://desenefaine.com/film/calatorie-in-tara-ta/) |
| 5 | Movie | Ciao Alberto | — | Correct | [Page](https://desenefaine.com/film/ciao-alberto/) |
| 6 | Movie | Căminul plutitor | — | Correct | [Page](https://desenefaine.com/film/caminul-plutitor/) |
| 7 | Movie | Scooby-Doo! Misterul de la WrestleMania | — | Correct | [Page](https://desenefaine.com/film/scooby-doo-misterul-de-la-wrestlemania/) |
| 8 | Movie | Crăciunul Piticoților | — | Correct | [Page](https://desenefaine.com/film/craciunul-piticotilor/) |
| 9 | Movie | Planeta maimuțelor | — | Correct | [Page](https://desenefaine.com/film/planeta-maimutelor-2001/) |
| 10 | Movie | FernGully: Ultima pădure tropicală | — | Correct | [Page](https://desenefaine.com/film/ferngully-ultima-padure-tropicala/) |
| 11 | Movie | Spărgătorul de Nuci și Cele Patru Tărâmuri | — | Correct | [Page](https://desenefaine.com/film/spargatorul-de-nuci-si-cele-patru-taramuri/) |
| 12 | Movie | Savva: Inimă de războinic | — | Correct | [Page](https://desenefaine.com/film/savva-inima-de-razboinic/) |
| 13 | Movie | Johnny Tsunami | — | Correct | [Page](https://desenefaine.com/film/johnny-tsunami/) |
| 14 | Movie | Awake | — | Correct | [Page](https://desenefaine.com/film/awake/) |
| 15 | Movie | Transporter 2 | — | Correct | [Page](https://desenefaine.com/film/transporter-2/) |
| 16 | Movie | Asterix și Obelix – Misiune: Cleopatra | — | Correct | [Page](https://desenefaine.com/film/asterix-and-obelix-mission-cleopatre/) |
| 17 | Movie | Elio | — | Correct | [Page](https://desenefaine.com/film/elio/) |
| 18 | Movie | Legendele din Oz: Întoarcerea lui Dorothy | — | Correct | [Page](https://desenefaine.com/film/legendele-din-oz-intoarcerea-lui-dorothy/) |
| 19 | Movie | TRON: Moștenirea | — | Correct | [Page](https://desenefaine.com/film/tron-mostenirea/) |
| 20 | Movie | F1 Filmul | — | Correct | [Page](https://desenefaine.com/film/f1-filmul/) |
| 21 | Movie | Stargirl | — | Correct | [Page](https://desenefaine.com/film/stargirl/) |
| 22 | Movie | Mama şi fiica: Aventuri în California | — | Correct | [Page](https://desenefaine.com/film/mama-si-fiica-aventuri-in-california/) |
| 23 | Movie | Coada duhului magic | — | Correct | [Page](https://desenefaine.com/film/a-genies-tail/) |
| 24 | Movie | Enola Holmes | — | Correct | [Page](https://desenefaine.com/film/enola-holmes/) |
| 25 | Movie | Barbie and Stacie to the Rescue | — | Correct | [Page](https://desenefaine.com/film/barbie-and-stacie-to-the-rescue/) |
| 26 | Movie | Venom: Ultimul dans | — | Correct | [Page](https://desenefaine.com/film/venom-ultimul-dans/) |
| 27 | Movie | Unicornul Thelma | — | Correct | [Page](https://desenefaine.com/film/unicornul-thelma/) |
| 28 | Movie | Captain America: Civil War | — | Correct | [Page](https://desenefaine.com/film/capitanul-america-razboi-civil/) |
| 29 | Movie | The Boogeyman | — | Correct | [Page](https://desenefaine.com/film/baubaul/) |
| 30 | Movie | Filmul artistic Tigrișor | — | Correct | [Page](https://desenefaine.com/film/filmul-artistic-tigrisor/) |
| 31 | Movie | Supermonstruleții și prietenii blănoși | — | Correct | [Page](https://desenefaine.com/film/supermonstruletii-si-prietenii-blanosi/) |
| 32 | Movie | Go! | — | Correct | [Page](https://desenefaine.com/film/go/) |
| 33 | Movie | Străini misterioși | — | Correct | [Page](https://desenefaine.com/film/straini-misteriosi/) |
| 34 | Movie | Stăpânul inelelor: Întoarcerea regelui | — | Correct | [Page](https://desenefaine.com/film/stapanul-inelelor-intoarcerea-regelui/) |
| 35 | Movie | Tom si Jerry: Furios si Iute | — | Correct | [Page](https://desenefaine.com/film/tom-si-jerry-furios-si-iute/) |
| 36 | Movie | Cum să-ți dresezi dragonul 3 | — | Correct | [Page](https://desenefaine.com/film/cum-sa-ti-dresezi-dragonul-3/) |
| 37 | Movie | Alfa și Omega 3: Marile Jocuri ale lupilor | — | Correct | [Page](https://desenefaine.com/film/alfa-si-omega-3-marile-jocuri-ale-lupilor/) |
| 38 | Movie | Ultimul Film Naruto | — | Correct | [Page](https://desenefaine.com/film/ultimul-film-naruto/) |
| 39 | Movie | Ben Gen 10 | — | Correct | [Page](https://desenefaine.com/film/ben-gen-10/) |
| 40 | Movie | Degețica | — | Correct | [Page](https://desenefaine.com/film/degetica/) |
| 41 | Movie | Batman Begins | — | Correct | [Page](https://desenefaine.com/film/batman-inceputuri/) |
| 42 | Movie | Godzilla x Kong: Un nou imperiu | — | Correct | [Page](https://desenefaine.com/film/godzilla-x-kong-un-nou-imperiu/) |
| 43 | Movie | LEGO: Marvel Super Eroii: Amplificare Maximă | — | Correct | [Page](https://desenefaine.com/film/lego-marvel-super-eroii-amplificare-maxima/) |
| 44 | Movie | Kate | — | Correct | [Page](https://desenefaine.com/film/kate/) |
| 45 | Movie | Ciudații Mei Părinți: Un Crăciun Magic | — | Verified duplicate | [Page](https://desenefaine.com/film/un-craciun-magic/) |
| 46 | Movie | Frankenweenie | — | Correct | [Page](https://desenefaine.com/film/frankenweenie/) |
| 47 | Movie | Prep & Landing | — | Correct | [Page](https://desenefaine.com/film/prep-landing/) |
| 48 | Movie | Spirit liber | — | Correct | [Page](https://desenefaine.com/film/spirit-liber/) |
| 49 | Movie | După vânătoare | — | Correct | [Page](https://desenefaine.com/film/dupa-vanatoare/) |
| 50 | Movie | Pentru păsări | — | Correct | [Page](https://desenefaine.com/film/pentru-pasari/) |
| 51 | Series | Zenimation | S2 E8 | Correct | [Page](https://desenefaine.com/epi/zenimation-sezonul-2-episodul-8/) |
| 52 | Series | Laboratorul lui Dexter | S2 E46 | Correct | [Page](https://desenefaine.com/epi/laboratorul-lui-dexter-s2-ep46/) |
| 53 | Series | Cei Patru Fantastici | S2 E1 | Correct | [Page](https://desenefaine.com/epi/cei-patru-fantastici-sezonul-2-episodul-1/) |
| 54 | Series | Ben 10 | S3 E7 | Correct | [Page](https://desenefaine.com/epi/ben-10-s3-ep7/) |
| 55 | Series | Palatul de Est | S1 E5 | Correct | [Page](https://desenefaine.com/epi/palatul-de-est-sezonul-1-episodul-5/) |
| 56 | Series | Unicorn: Războinicii Eterni | S1 E6 | Correct | [Page](https://desenefaine.com/epi/unicorn-razboinicii-eterni-sezonul-1-episodul-6/) |
| 57 | Series | Roata timpului | S2 E5 | Correct | [Page](https://desenefaine.com/epi/roata-timpului-s2-ep5/) |
| 58 | Series | Războiul stelelor: Andor | S2 E1 | Correct | [Page](https://desenefaine.com/epi/razboiul-stelelor-andor-sezonul-2-episodul-1/) |
| 59 | Series | Transformers: BotBots | S1 E6 | Correct | [Page](https://desenefaine.com/epi/transformers-botbots-s1-ep6/) |
| 60 | Series | Naruto: Shippûden | S12 E257 | Correct | [Page](https://desenefaine.com/epi/naruto-shippuden-s12-ep257/) |
| 61 | Series | Big Nate | S1 E5 | Correct | [Page](https://desenefaine.com/epi/big-nate-s1-ep5/) |
| 62 | Series | Hamsterii din Hamsterani | S1 E14 | Correct | [Page](https://desenefaine.com/epi/hamsterii-din-hamsterani-sezonul-1-episodul-14/) |
| 63 | Series | Invincibilul | S2 E8 | Correct | [Page](https://desenefaine.com/epi/invincibilul-sezonul-2-episodul-8/) |
| 64 | Series | Batman: Seria animată | S2 E20 | Correct | [Page](https://desenefaine.com/epi/batman-seria-animata-sezonul-2-episodul-20/) |
| 65 | Series | Eu și Mickey | S1 E1 | Correct | [Page](https://desenefaine.com/epi/eu-si-mickey-sezonul1-episoul1/) |
| 66 | Series | SimsalaGrimm | S2 E2 | Correct | [Page](https://desenefaine.com/epi/simsalagrimm-sezonul-2-episodul-2/) |
| 67 | Series | Marvel’s Hit-Monkey | S1 E6 | Correct | [Page](https://desenefaine.com/epi/marvels-hit-monkey-s1-ep6/) |
| 68 | Series | Președintele Curtis | S1 E6 | Correct | [Page](https://desenefaine.com/epi/presedintele-curtis-sezonul-1-episodul-6/) |
| 69 | Series | Gigantosaurus | S1 E15 | Correct | [Page](https://desenefaine.com/epi/gigantosaurus-s1-ep15/) |
| 70 | Series | Piatra, Hartie și Foarfeca | S1 E12 | Correct | [Page](https://desenefaine.com/epi/piatra-hartie-si-foarfeca-sezonul-1-episodul-12/) |
| 71 | Series | Ei sunt Batroțile | S1 E14 | Correct | [Page](https://desenefaine.com/epi/ei-sunt-batrotile-sezonul-1-episodul-14/) |
| 72 | Series | Football Must Go On | S1 E3 | Correct | [Page](https://desenefaine.com/epi/football-must-go-on-s1-ep3/) |
| 73 | Series | DOGMATIX ŞI NEINDUPLECAŢII | S1 E29 | Correct | [Page](https://desenefaine.com/epi/dogmatix-si-neinduplecatii-sezonul-1-episodul-29/) |
| 74 | Series | Fantoma și Molly McGee | S1 E12 | Correct | [Page](https://desenefaine.com/epi/fantoma-si-molly-mcgee-s1-ep12/) |
| 75 | Series | Kick Buttowski | S1 E8 | Correct | [Page](https://desenefaine.com/epi/kick-buttowski-sezonul-1-episodul-8/) |
| 76 | Series | Dora Exploratoarea | S8 E3 | Correct | [Page](https://desenefaine.com/epi/dora-exploratoarea-sezonul-8-episodul-3/) |
| 77 | Series | Kiya Și Maeștrii Kimoja | S1 E15 | Correct | [Page](https://desenefaine.com/epi/kiya-si-maestrii-kimoja-sezonul-1-episodul-15/) |
| 78 | Series | Avatar: Ultimul războinic al aerului | S2 E1 | Correct | [Page](https://desenefaine.com/epi/avatar-ultimul-razboinic-al-aerului-sezonul-2-episodul-1/) |
| 79 | Series | Drama Totala: Reuniunea Vedetelor | S1 E6 | Correct | [Page](https://desenefaine.com/epi/drama-totala-reuniunea-vedetelor-sezonul1-episoul6/) |
| 80 | Series | Hard Broken | S1 E4 | Correct | [Page](https://desenefaine.com/epi/hard-broken-s1-ep4/) |
| 81 | Series | Dune: Profeția | S1 E4 | Correct | [Page](https://desenefaine.com/epi/dune-profetia-sezonul-1-episodul-4/) |
| 82 | Series | WondLa | S2 E5 | Correct | [Page](https://desenefaine.com/epi/wondla-sezonul-2-episodul-5/) |
| 83 | Series | Calea Misterelor | S1 E15 | Correct | [Page](https://desenefaine.com/epi/calea-misterelor-sezonul-1-episodul-15/) |
| 84 | Series | Casa Loud | S5 E8 | Correct | [Page](https://desenefaine.com/epi/casa-loud-s5-ep8/) |
| 85 | Series | Noile legende ale Regelui Maimuță | S1 E6 | Correct | [Page](https://desenefaine.com/epi/noile-legende-ale-regelui-maimuta-s1-ep6/) |
| 86 | Series | Punct de cotitură: Bomba și Războiul Rece | S1 E5 | Correct | [Page](https://desenefaine.com/epi/punct-de-cotitura-bomba-si-razboiul-rece-sezonul-1-episodul-5/) |
| 87 | Series | Fii tare, Scooby-Doo! | S2 E3 | Correct | [Page](https://desenefaine.com/epi/fii-tare-scooby-doo-sezonul-2-episodul-3/) |
| 88 | Series | Hannah Montana | S2 E30 | Correct | [Page](https://desenefaine.com/epi/hannah-montana-sezonul-2-episodul-30/) |
| 89 | Series | Lamput | S4 E5 | Correct | [Page](https://desenefaine.com/epi/lamput-sezonul-4-episodul-5/) |
| 90 | Series | Miles în Spațiu | S2 E12 | Correct | [Page](https://desenefaine.com/epi/miles-in-spatiu-s2-ep12/) |
| 91 | Series | Dear Child | S1 E4 | Correct | [Page](https://desenefaine.com/epi/dear-child-s1-ep4/) |
| 92 | Series | Viața cu Louie | S2 E9 | Correct | [Page](https://desenefaine.com/epi/viata-cu-louie-sezonul-2-episodul-9/) |
| 93 | Series | Păpădie | S1 E4 | Correct | [Page](https://desenefaine.com/epi/papadie-sezonul-1-episodul-4/) |
| 94 | Series | M-am trezit vampir | S1 E5 | Correct | [Page](https://desenefaine.com/epi/m-am-trezit-vampir-s1-ep5/) |
| 95 | Series | Stranger Things: Povești din ’85 | S1 E10 | Correct | [Page](https://desenefaine.com/epi/stranger-things-povesti-din-85-sezonul-1-episodul-10/) |
| 96 | Series | Burning Body | S1 E5 | Correct | [Page](https://desenefaine.com/epi/burning-body-s1-ep5/) |
| 97 | Series | Elena din Avalor | S2 E17 | Correct | [Page](https://desenefaine.com/epi/elena-din-avalor-s2-ep17/) |
| 98 | Series | Bona mea este un vampir | S1 E8 | Correct | [Page](https://desenefaine.com/epi/bona-mea-este-un-vampir-s1-ep8/) |
| 99 | Series | Războiul Stelelor: Echipajul de bază | S1 E5 | Correct | [Page](https://desenefaine.com/epi/razboiul-stelelor-echipajul-de-baza-sezonul-1-episodul-5/) |
| 100 | Series | H2O:  Adaugă apă | S2 E17 | Correct | [Page](https://desenefaine.com/epi/h2o-adauga-apa-sezonul-2-episodul-17/) |

Original and test repositories remain unchanged. Netu/Playmogo remain excluded.
