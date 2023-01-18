## Iskolai tantárgyak

## Bevezetés

Egy iskolának készítesz programot, ahol szükség lenne a diákok listájának különböző kezdési dátumok és tantárgyak szerinti csoportosítására.

## Feladatleírás

Készíts egy, a teszteknek megfelelő `Student` osztályt, amiben tárolni tudod a következő adatokat:
a diák nevét, kezdési dátumát és a tantárgyait (String halmazban tárolva).

Készíts el egy, a teszteknek megfelelő `SchoolSystem` osztályt, mely:

- a diákok listáját konstruktor paraméterben kapja meg, ha ez null, dobjon `IllegalArgumentException`-t. Tartozik hozzá egy getter.
- képes visszaadni a diákokat akik a paraméterben megadott tantárgyat tanulják
    - `List<Student> getListOfStudentsLearningSubject(String subject)`
- képes kitörölni a paraméterben megadott tantárgyat az összes diáktól
    - `void deleteSubjectFromAllStudents(String subject)`
- képes visszaadni a diákok listáját akik a megadott napon kezdték a sulit
  - `List<Student> getListOfStudentsByStartDate(LocalDate date) `
- képes visszaadni az iskolakezdési dátumokat és a hozzájuk tartozó diákok listáját
  - `Map<LocalDate, List<Student>> getListOfStudentsGroupByStartDate()`
- képes visszaadni azoknak a tantárgyaknak a halmazát, amit a paraméterben megadott diákok mind tanulnak. 
Ha null vagy üres a diákok megadott listája, dobjunk IllegalArgumentException-t!
    - `Set<String> getCommonSubjectsAmongStudents(Set<String> studentNames) `

A munka során a kísérletezéshez tetszőlegesen létrehozhatsz `main` metódust, illetve akár készíthetsz másik
osztályt `main` metódussal.

A teszteket nem szabad módosítani!

## Pontozás

Egy feladatra 0 pontot ér, ha:

- nem fordul le
- lefordul, de egy teszteset sem fut le sikeresen.
- ha a forráskód olvashatatlan, nem felel meg a konvencióknak, nem követi a clean code alapelveket.

0 pont adandó továbbá, ha:

- kielégíti a teszteseteket, de a szöveges követelményeknek nem felel meg

Pontokat a további működési funkciók megfelelősségének arányában kell adni a vizsgafeladatra:

- 5 pont: az adott projekt lefordul, néhány teszteset sikeresen lefut, és ezek funkcionálisan is helyesek. Azonban több
  teszteset nem fut le, és a kód is olvashatatlan.
- 10 pont: a projekt lefordul, a tesztesetek legtöbbje lefut, ezek funkcionálisan is helyesek, és a clean code elvek
  nagyrészt betartásra kerültek.
- 20 pont: ha a projekt lefordul, a tesztesetek lefutnak, funkcionálisan helyesek, és csak apróbb funkcionális vagy
  clean code hibák szerepelnek a megoldásban.

Gyakorlati pontozás a project feladatokhoz:

- Alap pontszám egy feladatra(max 20): lefutó egység tesztek száma / összes egység tesztek száma * 20, feltéve, hogy a
  megoldás a szövegben megfogalmazott feladatot valósítja meg
- Clean kód, programozási elvek, bevett gyakorlat, kód formázás megsértéséért - pontlevonás jár. Szintén pontlevonás
  jár, ha valaki a feladatot nem a leghatékonyabb módszerrel oldja meg - amennyiben ez értelmezhető.
