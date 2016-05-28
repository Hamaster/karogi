package com.example.toms.karogi;
import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHandler extends SQLiteOpenHelper{
    // Database Version
	private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "karogiDatabse";
    private static final String COUNTRY_TABLE = "countries";

    //questions table gots these column names:
    private static final String QID = "qid";
    private static final String COUNTRY_NAME = "countryName";
    private static final String FLAG_IMAGE_NAME = "flagImageName";
    private static final String REGION = "region";

    //private SQLiteDatabase database;
    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


   // SQLiteDatabase database;
    @Override
    public void onCreate(SQLiteDatabase database){ //create table statements
       // this.database = database;
        String tableCreation = "CREATE TABLE "+ COUNTRY_TABLE +" ( "+QID+" INTEGER PRIMARY KEY, "+ COUNTRY_NAME+" TEXT, "+FLAG_IMAGE_NAME+" TEXT, "+ REGION +" TEXT)";
        database.execSQL(tableCreation);
        addQuestions(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldV, int newV){
        database.execSQL("DROP TABLE IF EXISTS "+ COUNTRY_TABLE);
        onCreate(database);
    }

    //crud
    public void addQuestions(SQLiteDatabase db){
        Country q;

        //Europe
        q = new Country(1, "Igaunija","igaunija", "Eiropa");
        addCountry(q, db);
        q = new Country(2, "Lietuva", "lietuva", "Eiropa");
        addCountry(q, db);
        q = new Country(3, "Krievija", "krievija", "Eiropa");
        addCountry(q, db);
        q = new Country(4, "Zviedrija", "zviedrija", "Eiropa");
        addCountry(q, db);
        q = new Country(5, "Somija", "somija", "Eiropa");
        addCountry(q, db);
        q = new Country(6, "Norvēģija", "norvegija", "Eiropa");
        addCountry(q, db);
        q = new Country(7, "Dānija", "danija", "Eiropa");
        addCountry(q, db);
        q = new Country(8, "Polija", "polija", "Eiropa");
        addCountry(q, db);
        q = new Country(9, "Apvienotā Karaliste", "uk", "Eiropa");
        addCountry(q, db);
        q= new Country(10, "Spānija", "esp", "Eiropa");
        addCountry(q, db);
        q = new Country(11, "Portugāle", "portugal", "Eiropa");
        addCountry(q, db);
        q = new Country(12, "Ukraina", "ukraine", "Eiropa");
        addCountry(q, db);
        q = new Country(13, "Slovēnija", "slovenia", "Eiropa");
        addCountry(q, db);
        q = new Country(14, "Itālija", "italy", "Eiropa");
        addCountry(q, db);
        q = new Country(15, "Austrija", "austria", "Eiropa");
        addCountry(q, db);
        q = new Country(16, "Īrija", "ireland", "Eiropa");
        addCountry(q, db);
        q = new Country(17, "Vācija", "germany", "Eiropa");
        addCountry(q, db);
        q = new Country(18, "Francija", "france", "Eiropa");
        addCountry(q, db);
        q = new Country(19, "Horvātija", "croatia", "Eiropa");
        addCountry(q, db);
        q = new Country(20, "Šveice", "switzerland", "Eiropa");
        addCountry(q, db);
        q = new Country(21, "Vatikāns", "vatikan", "Eiropa");
        addCountry(q, db);
        q = new Country(22, "Beļģija", "belgium", "Eiropa");
        addCountry(q, db);
        q = new Country(23, "Čehija", "ch", "Eiropa");
        addCountry(q, db);
        q = new Country(24, "Moldova", "moldova", "Eiropa");
        addCountry(q, db);
        q = new Country(25, "Latvija", "latvija", "Eiropa");
        addCountry(q, db);
        q = new Country(26, "Rumānija", "r", "Eiropa");
        addCountry(q, db);
        q = new Country(27, "Serbija un Melnkalne", "sm", "Eiropa");
        addCountry(q, db);
        q = new Country(28, "Baltkrievija", "bk", "Eiropa");
        addCountry(q, db);
        q = new Country(29, "Bulgārija", "bulgarija", "Eiropa");
        addCountry(q, db);
        q = new Country(30, "Slovākija", "slovakia", "Eiropa");
        addCountry(q, db);
        q = new Country(31, "Nīderlande", "niderlande", "Eiropa");
        addCountry(q, db);
        q = new Country(32, "Grieķija", "greece", "Eiropa");
        addCountry(q, db);
        q = new Country(33, "Islande", "iceland", "Eiropa");
        addCountry(q, db);
        q = new Country(34, "Luksemburga", "lux", "Eiropa");
        addCountry(q, db);
        q = new Country(35, "Malta", "malta", "Eiropa");
        addCountry(q, db);
        q = new Country(36, "Ungārija", "hun", "Eiropa");
        addCountry(q, db);

        //Asia
        q = new Country(37, "Afganistāna", "afganistan", "Āzija");
        addCountry(q, db);
        q = new Country(38, "Filipīnas", "fil", "Āzija");
        addCountry(q, db);
        q = new Country(39, "Sīrija", "sir", "Āzija");
        addCountry(q, db);
        q = new Country(40, "Izrēla", "israel", "Āzija");
        addCountry(q, db);
        q = new Country(41, "Malaizija", "malaysia", "Āzija");
        addCountry(q, db);
        q = new Country(42, "Katara", "katar", "Āzija");
        addCountry(q, db);
        q = new Country(43, "Saūda Arābija", "sa", "Āzija");
        addCountry(q, db);
        q = new Country(44, "Apvienotie Arābu Emirāti", "uae", "Āzija");
        addCountry(q, db);
        q = new Country(45, "Ziemeļkoreja", "nk", "Āzija");
        addCountry(q, db);
        q = new Country(46, "Japāna", "jp", "Āzija");
        addCountry(q, db);
        q = new Country(47, "Dienvidkoreja", "sk", "Āzija");
        addCountry(q, db);
        q = new Country(48, "Vjetnama", "vj", "Āzija");
        addCountry(q, db);
        q = new Country(49, "Pakistāna", "pk", "Āzija");
        addCountry(q, db);
        q = new Country(50, "Hongkonga", "hk", "Āzija");
        addCountry(q, db);
        q = new Country(51, "Indija", "in", "Āzija");
        addCountry(q, db);
        q = new Country(52, "Indonēzija", "indonezija", "Āzija");
        addCountry(q, db);
        q = new Country(53, "MOngolija", "mongolija", "Āzija");
        addCountry(q, db);
        q = new Country(54, "Kazahstāna", "kazah", "Āzija");
        addCountry(q, db);
        q = new Country(55, "Irāka", "iraka", "Āzija");
        addCountry(q, db);
        q = new Country(56, "Kirgizstāna", "kir", "Āzija");
        addCountry(q, db);
        q = new Country(57, "Irāna", "iran", "Āzija");
        addCountry(q, db);
        q = new Country(58, "Kambodža", "cambodia", "Āzija");
        addCountry(q, db);
        q = new Country(59, "Azarbeidžāna", "azer", "Āzija");
        addCountry(q, db);
        q = new Country(60, "Ķīna", "china", "Āzija");
        addCountry(q, db);
        q = new Country(61, "Tiavāna", "tw", "Āzija");
        addCountry(q, db);
        q = new Country(62, "Singapūra", "sing", "Āzija");
        addCountry(q, db);
        q = new Country(63, "Turcija", "turk", "Āzija");
        addCountry(q, db);
        q = new Country(64, "Taizeme", "tz", "Āzija");
        addCountry(q, db);
        q = new Country(65, "Turkmenistāna", "turkm", "Āzija");
        addCountry(q, db);

        //Afrika
        q = new Country(66, "Nigērija", "nigerija", "Āfrika");
        addCountry(q, db);
        q = new Country(67, "Tunisija", "tun", "Āfrika");
        addCountry(q, db);
        q = new Country(68, "Etiopija", "etiopija", "Āfrika");
        addCountry(q, db);
        q = new Country(69, "Somālija", "som", "Āfrika");
        addCountry(q, db);
        q = new Country(70, "Zimbabve", "zimbabve", "Āfrika");
        addCountry(q, db);
        q = new Country(71, "Zambija", "zambia", "Āfrika");
        addCountry(q, db);
        q = new Country(72, "Alžīrija", "alzirija", "Āfrika");
        addCountry(q, db);
        q = new Country(73, "Centrālāfrikas Republika", "car", "Āfrika");
        addCountry(q, db);
        q = new Country(74, "Ēģipte", "egypt", "Āfrika");
        addCountry(q, db);
        q = new Country(75, "Kongo Demokrātiskā Republika", "car", "Āfrika");
        addCountry(q, db);
        q = new Country(76, "Eritreja", "eritrea", "Āfrika");
        addCountry(q, db);
        q = new Country(77, "Sudāna", "sudan", "Āfrika");
        addCountry(q, db);
        q = new Country(78, "Kenija", "kenija", "Āfrika");
        addCountry(q, db);
        q = new Country(79, "Madagaskara", "mada", "Āfrika");
        addCountry(q, db);
        q = new Country(80, "Mauritānija", "mauritania", "Āfrika");
        addCountry(q, db);
        q = new Country(81, "DienvidĀfrikas Republika", "dar", "Āfrika");
        addCountry(q, db);
        q = new Country(82, "Čada", "chad", "Āfrika");
        addCountry(q, db);
        q = new Country(83, "Senegāla", "senegal", "Āfrika");
        addCountry(q, db);
        q = new Country(84, "Mozambika", "mozambika", "Āfrika");
        addCountry(q, db);


        //ZAmerika
        q = new Country(85, "ASV", "usa", "Ziemeļamerika");
        addCountry(q, db);
        q = new Country(86, "Meksika", "mexico", "Ziemeļamerika");
        addCountry(q, db);
        q = new Country(87, "Kanāda", "canada", "Ziemeļamerika");
        addCountry(q, db);
        q = new Country(88, "Bermunda", "bermunda", "Ziemeļamerika");
        addCountry(q, db);
        q = new Country(89, "Kuba", "kuba", "Ziemeļamerika");
        addCountry(q, db);
        q = new Country(90, "Gvatemala", "gva", "Ziemeļamerika");
        addCountry(q, db);
        q = new Country(91, "Nikaragva", "nika", "Ziemeļamerika");
        addCountry(q, db);
        q = new Country(92, "Panama", "panama", "Ziemeļamerika");
        addCountry(q, db);

        //DAmerika
        q = new Country(93, "Brazīlija", "brazil", "Dienvidamerika");
        addCountry(q, db);
        q = new Country(94, "Urugvaja", "urg", "Dienvidamerika");
        addCountry(q, db);
        q = new Country(95, "Argentīna", "argentina", "Dienvidamerika");
        addCountry(q, db);
        q = new Country(96, "Čīle", "chile", "Dienvidamerika");
        addCountry(q, db);
        q = new Country(97, "Peru", "peru", "Dienvidamerika");
        addCountry(q, db);
        q = new Country(98, "Bolīvija", "bolivia", "Dienvidamerika");
        addCountry(q, db);
        q = new Country(99, "Paragvaja", "para", "Dienvidamerika");
        addCountry(q, db);
        q = new Country(100, "Ekvadora", "ekva", "Dienvidamerika");
        addCountry(q, db);
        q = new Country(101, "Kolumbija", "kolumbija", "Dienvidamerika");
        addCountry(q, db);
        q = new Country(102, "Puerto Riko", "pr", "Dienvidamerika");
        addCountry(q, db);
        q = new Country(103, "Venecuēla", "ven", "Dienvidamerika");
        addCountry(q, db);

        //Australia + Okeanija
        q = new Country(104, "Austrālija", "australia", "AOk");
        addCountry(q, db);
        q = new Country(105, "Fidži", "fiji", "AOk");
        addCountry(q, db);
        q = new Country(106, "Kiribati", "kiribati", "AOk");
        addCountry(q, db);
        q = new Country(107, "Maršala salas", "ms", "AOk");
        addCountry(q, db);
        q = new Country(108, "Mikronēzija", "mic", "AOk");
        addCountry(q, db);
        q = new Country(109, "Nauru", "nauru", "AOk");
        addCountry(q, db);
        q = new Country(110, "Jaunzelande", "nz", "AOk");
        addCountry(q, db);
        q = new Country(111, "Palau", "pal", "AOk");
        addCountry(q, db);
        q = new Country(112, "Papua Jaungvijeja", "pjg", "AOk");
        addCountry(q, db);
        q = new Country(113, "Samoa", "samoa", "AOk");
        addCountry(q, db);
        q = new Country(114, "Zālamana salas", "zal", "AOk");
        addCountry(q, db);
        q = new Country(115, "Tonga", "tong", "AOk");
        addCountry(q, db);
        q = new Country(116, "Tuvalu", "tuvalu", "AOk");
        addCountry(q, db);
        q = new Country(117, "Vanuatu", "van", "AOk");
        addCountry(q, db);
        //db.close(); // Closing database connection
    }

    public void addCountry(Country country,  SQLiteDatabase db){
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(QID, country.getiD());
        values.put(COUNTRY_NAME, country.getCountryName());
        values.put(FLAG_IMAGE_NAME, country.getFlagImageName());
        values.put(REGION, country.getRegion());
        db.insert(COUNTRY_TABLE, null, values);
        //db.close(); // Closing database connection
    }

    public List<Country> getAllCountries() {
        List<Country> quesList = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+ COUNTRY_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                Country country = new Country();
                country.setiD(Integer.parseInt(cursor.getString(0)));
                country.setCountryName(cursor.getString(1));
                country.setFlagImageName(cursor.getString(2));
                country.setRegion(cursor.getString(3));//?
                quesList.add(country);
            }while (cursor.moveToNext());
        }
        //db.close(); // Closing database connection
        return quesList;
    }

    public List<Country> getAllCountriesAfrica() {
        List<Country> quesList = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+ COUNTRY_TABLE +" WHERE "+REGION+" ='Āfrika'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                Country country = new Country();
                country.setiD(Integer.parseInt(cursor.getString(0)));
                country.setCountryName(cursor.getString(1));
                country.setFlagImageName(cursor.getString(2));
                country.setRegion(cursor.getString(3));
                quesList.add(country);
            }while (cursor.moveToNext());
        }
        //db.close(); // Closing database connection
        return quesList;
    }

    public List<Country> getAllCountriesAustralijaOkeanija() {
        List<Country> quesList = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+ COUNTRY_TABLE +" WHERE "+REGION+" ='AOk'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                Country country = new Country();
                country.setiD(Integer.parseInt(cursor.getString(0)));
                country.setCountryName(cursor.getString(1));
                country.setFlagImageName(cursor.getString(2));
                country.setRegion(cursor.getString(3));
                quesList.add(country);
            }while (cursor.moveToNext());
        }
        //db.close(); // Closing database connection
        return quesList;
    }

    public List<Country> getAllCountriesZAmerika() {
        List<Country> quesList = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+ COUNTRY_TABLE +" WHERE "+REGION+" ='Ziemeļamerika'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                Country country = new Country();
                country.setiD(Integer.parseInt(cursor.getString(0)));
                country.setCountryName(cursor.getString(1));
                country.setFlagImageName(cursor.getString(2));
                country.setRegion(cursor.getString(3));
                quesList.add(country);
            }while (cursor.moveToNext());
        }
        //db.close(); // Closing database connection
        return quesList;
    }

    public List<Country> getAllCountriesDAmerika() {
        List<Country> quesList = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+ COUNTRY_TABLE +" WHERE "+REGION+" ='Dienvidamerika'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                Country country = new Country();
                country.setiD(Integer.parseInt(cursor.getString(0)));
                country.setCountryName(cursor.getString(1));
                country.setFlagImageName(cursor.getString(2));
                country.setRegion(cursor.getString(3));
                quesList.add(country);
            }while (cursor.moveToNext());
        }
        //db.close(); // Closing database connection
        return quesList;
    }

    public List<Country> getAllCountriesAzija() {
        List<Country> quesList = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+ COUNTRY_TABLE +" WHERE "+REGION+" ='Āzija'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                Country country = new Country();
                country.setiD(Integer.parseInt(cursor.getString(0)));
                country.setCountryName(cursor.getString(1));
                country.setFlagImageName(cursor.getString(2));
                country.setRegion(cursor.getString(3));
                quesList.add(country);
            }while (cursor.moveToNext());
        }
        //db.close(); // Closing database connection
        return quesList;
    }

    public List<Country> getAllCountriesEiropa() {
        List<Country> quesList = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+ COUNTRY_TABLE +" WHERE "+REGION+" ='Eiropa'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                Country country = new Country();
                country.setiD(Integer.parseInt(cursor.getString(0)));
                country.setCountryName(cursor.getString(1));
                country.setFlagImageName(cursor.getString(2));
                country.setRegion(cursor.getString(3));
                quesList.add(country);
            }while (cursor.moveToNext());
        }
        //db.close(); // Closing database connection
        return quesList;
    }

    public int getAfrikaCountryCount(){
        SQLiteDatabase db = this.getReadableDatabase();
        return (int)DatabaseUtils.queryNumEntries(db, COUNTRY_TABLE, REGION+" ='Āfrika'");
    }

    public int getAustralijaOkeanijaCountryCount(){
        SQLiteDatabase db = this.getReadableDatabase();
        return (int)DatabaseUtils.queryNumEntries(db, COUNTRY_TABLE, REGION+" ='AOk'");
    }

    public int getZAmerikaCountryCount(){
        SQLiteDatabase db = this.getReadableDatabase();
        return (int)DatabaseUtils.queryNumEntries(db, COUNTRY_TABLE, REGION+" ='Ziemeļamerika'");
    }

    public int getDAmerikaCountryCount(){
        SQLiteDatabase db = this.getReadableDatabase();
        return (int)DatabaseUtils.queryNumEntries(db, COUNTRY_TABLE, REGION+" ='Dienvidamerika'");
    }

    public int getAzijaCountryCount(){
        SQLiteDatabase db = this.getReadableDatabase();
        return (int)DatabaseUtils.queryNumEntries(db, COUNTRY_TABLE, REGION+" ='Āzija'");
    }

    public int getEuropeCountryCount(){
        SQLiteDatabase db = this.getReadableDatabase();
        return (int)DatabaseUtils.queryNumEntries(db, COUNTRY_TABLE, REGION+" ='Eiropa'");
    }
}
