##Klases

#### Country
###### Metodes
* int getId() -- atgrieš valsts iD
* String getCountryName() --atgriež valsts nosaukums
* String getFlagImageName() -- atgriež karoga attēla nosaukums
* String getRegion() -- atgriež reģionu

* void setId(int iD) -- piešķir iD
* void setCountryName(String countryName) --uzstāda valsts nosaukums
* void setFlagImageName(String flagImageName) --uzstāda karoga attēla nosaukums
* void setRegion(String region) --uzstāda reģionu

###### Mainīgie
* int Id unikāls  --valsts iD //reāli neizmanto nekur
* String countryName --valsts nosaukums
* String flagImageName --karoga attēla nosaukums
* String region --valsts reģions

----
#### DatabaseHandler
###### Metodes
* void onCreate(SQLiteDatabase database) -- izveido tabulas, piepilda tās
* public void onUpgrade(SQLiteDatabase database, int oldV, int newV) -- izdzēš esošās tabulas, izveido jaunas
* void addQuestions(SQLiteDatabase db) -- piepilda valstu tabulu
* void addCountry(Country country,  SQLiteDatabase db) -- pievieno valsti datubāzei
* List<Country> getAllCountries() -- atgriež sarakstu ar visām valstīm
* List<Country> getAllCountriesAfrica() -- atgriež sarakstu ar visām valstīm Āfrikā
* List<Country> getAllCountriesAustralijaOkeanija() -- atgriež sarakstu ar visām valstīm Austrālijā un Okeānijā
* List<Country> getAllCountriesZAmerika() -- atgriež sarakstu ar visām valstīm Ziemeļamerikā
* List<Country> getAllCountriesDAmerika() -- atgriež sarakstu ar visām valstīm Dienvidamerikā
* List<Country> getAllCountriesAzija() -- atgriež sarakstu ar visām valstīm Āzijā
* List<Country> getAllCountriesEiropa() -- atgriež sarakstu ar visām valstīm Eiropā
* int getAfrikaCountryCount() -- atgriež valstu skaitu Āfrikā
* int getAustralijaOkeanijaCountryCount() -- atgriež valstu skaitu Austrālijā un Okeānijā
* int getZAmerikaCountryCount() -- atgriež valstu skaitu Ziemeļamerikā
* int getDAmerikaCountryCount() -- atgriež valstu skaitu Dienvidamerikā
* int getAzijaCountryCount() -- atgriež valstu skaitu Āzijā
* int getEuropeCountryCount() -- atgriež valstu skaitu Eiropā
* int getRecord() -- atgriež rekordu
* void addRecord(String record) -- pievieno jaunu rekordu datubāzē

###### Mainīgie
* int DATABASE_VERSION -- datubāzes verisja
* String DATABASE_NAME -- datubāzes nosaukums
* String COUNTRY_TABLE -- valstu tabulas nosaukums
* String RECORDS_TABLE -- rekordu tabulas nosaukums
* String QID -- valstu un rekordu tabulu primary key kolonnas nosaukums
* String COUNTRY_NAME -- valstu nosaukumu kolonnas nosaukums
* String FLAG_IMAGE_NAME -- karogu attēlu nosaukumu kolonnas nosaukums
* String REGION -- reģionu kolonnas nosaukums
* String RECORDS -- rekordu kolonnas nosaukums
* String CREATE_TABLE_COUNTRIES -- valstu tabulas izveides skripts
* String CREATE_TABLE_RECORDS -- rekordu tabulas izveides skripts
* String ADD_ZERO_T0_RECORDS -- skripts noklusējuma vērtības ievietošanai rekordu tabulā

----
#### MainActivity
###### Metodes
* void onCreate(Bundle savedInstanceState) -- izsauc metodes, kuras inicializē visu pogu funkcionalitātes
* boolean evaluateSakt() -- izvērtē, vai poga "sākt" ir aktīva
* String[] evaluateRegions() -- reģistrē String masīvā lietotāja reģionu izvēli
* void saktBackgroundCheck() -- izmaina pogas "sākt" attēlu atkarībā no lietotāja izvēles
* int evaluateQuestionCount() -- izvērtē lietotāja jautājumu skaita izvēli
* void addListenersForMenuButtons() -- inicializē rekordu un sākt pogas
* void addListenersForAreaButtons() -- inicializē reģionu pogas
* void addListenersOnNumberButtons() -- inicializē jautājumu skaita pogas

###### Mainīgie
* ImageButton button_5 -- poga "5"
* ImageButton button_10 -- poga "10"
* ImageButton button_15 -- poga "15"
* ImageButton button_20 -- poga "20"
* ImageButton button_50 -- poga "50"
* ImageButton visasValstis  -- poga
* ImageButton afrika -- poga afrika
* ImageButton australijaUnOkeanija -- poga australijaUnOkeanija
* ImageButton ziemelAmerika -- poga ziemelAmerika
* ImageButton azija -- poga azija
* ImageButton dienvidAmerika -- poga dienvidAmerika
* ImageButton eiropa -- poga eiropa
* ImageButton rekordi -- poga rekordi
* ImageButton sakt -- poga saktsakt
* boolean btn5 -- atbild vai poga "5" ir nospiesta
* boolean btn10 -- atbild vai poga "10" ir nospiesta
* boolean btn15 -- atbild vai poga "15" ir nospiesta
* boolean btn20 -- atbild vai poga "20" ir nospiesta
* boolean btn50 -- atbild vai poga "50" ir nospiesta
* boolean btnVisasValstis -- atbild vai poga "visasValstis" ir nospiesta
* boolean btnAfrika -- atbild vai poga "afrika" ir nospiesta
* boolean btnAustralijaUnOkeanija -- atbild vai poga "australijaUnOkeanija" ir nospiesta
* boolean btnZiemelAmerika -- atbild vai poga "ziemelAmerika" ir nospiesta
* boolean btnAzija -- atbild vai poga "azija" ir nospiesta
* boolean btnDienvidAmerika -- atbild vai poga "dienvidAmerika" ir nospiesta
* boolean btnEiropa -- atbild vai poga "eiropa" ir nospiesta
* boolean saktIsActive -- atbild vai poga "sakt" ir var tikt nospiesta
* int questionCount -- satur lietotāja izvēlēto jautājumu skaitu

----
#### QuestionsActivity
###### Metodes
* void onCreate(Bundle savedInstanceState) -- iegūst jautājumu skaitu, reģionus, izsauc pārējās metodes
* void addListenersForButtons() -- inicializē visas pogas
* void getAnswer(Object object) -- izvērtē atbildes pareizību, sāk nākošo jautājumu, ja tāds ir
* int[] getRandomNumberArr(int max, int size) -- izveido nejaušas secības masīvu izmērā size ar lielāko vērtību max
* void shuffleArray(int[] array) -- pārkārto masīva elementus nejaušā secībā
* boolean arrHasNumber(int[] a, int key) -- meklē key ciparu masīvā a
* List<Country> setSelectedCountryList(String[] regions) -- atkarībā no reģioniem, pievieno valstis sarakstam
* setQuestionView() -- atjauno jautājumus

###### Mainīgie
* List<Country>countryList -- saraksts ar valstīm
* int score -- iegūtie punkti
* int currentQuestion -- pašlaik uzdotais jautājums, valsts
* int qcount -- jautājumu skaits
* String [] regions -- izvēlētie reģioni
* Country trueCountry -- valsts, kas ir pareizā atbilde
* TextView txtCountry -- teksta skats, kurā uzdots valsts nosaukums
* TextView currQ -- patreizējais valsts objekts
* ImageButton btnA -- izvēles poga
* ImageButton btnB -- izvēles poga
* ImageButton btnC -- izvēles poga
* ImageButton btnD -- izvēles poga
* ImageButton[] imgBArr -- izvēles pogu masīvs
* ImageButton btnPartraukt -- poga pārtraukt
* DatabaseHandler databaseHandler -- datubāzes objets

----
#### RecordsActivity
###### Metodes
* void onCreate() -- pieprasa no datubāzes rekordu, inicializē visus skatus un parāda rekordu

###### Mainīgie
* ImageButton goHome -- poga, lai atgrieztos uz izvēlni
* TextView record -- teksts, kurš parāda rekordu
* int rec -- satur rekordu
* DatabaseHandler databaseHandler -- datubāzes objekts

----
#### RezultsActivity
###### Metodes
* void onCreate(Bundle savedInstanceState) -- inicializē mainīgos, iegūst un parāda rekordu, precizitati, jautājumu skaitu

###### Mainīgie
* TextView pareiziAtbJaut -- teksta skats pareizi atbildetajiem jautajumiem
* TextView precizitate -- teksta skats precizitatei
* TextView punkti -- teksta skats iegūtajiem punktiem
* TextView augstakaisRezultats -- teksta skats rekordam
* ImageButton atkartot -- poga, lai atkrtoti atbildetu uz jautājumiem
* ImageButton uzIzvelni -- poga, lai atgrieztos uz izvēlni
* double score -- mainīgais aprēķiniem
* int total -- mainīgais aprēķiniemmainīgais aprēķiniem
* double precizion -- satur jautājumu atbildēšanas precizitāti
* int points -- iegūtie punkti
* int record -- patreizējais rekords
* String[] regions -- reģioni, no kuriem atlasītas valstis
* DatabaseHandler databaseHandler -- datubāzes objekts

----
#### SplashActivity
###### Metodes
* void onCreate() -- kamēr ielādējas MainActivity, uz ekrāna parāda lietotnes ikonu
###### Mainīgo nav
