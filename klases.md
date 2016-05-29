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
