package com.example.toms.karogi;
import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHandler extends SQLiteOpenHelper{
    // Database Version
	private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "karogiDatabse";
    private static final String QUESTION_TABLE_NAME = "countries";

    //questions table gots these column names:
    private static final String QID = "qid";
    private static final String COUNTRY_NAME = "countryName";
    private static final String FLAG_IMAGE_NAME = "flagImageName";
    private static final String REGION = "region";

    //private SQLiteDatabase database;

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database){ //create table statements
       // this.database = database;
        String tableCreation = "CREATE TABLE "+QUESTION_TABLE_NAME+" ( "+QID+" INTEGER PRIMARY KEY, "+ COUNTRY_NAME+" TEXT, "+FLAG_IMAGE_NAME+" TEXT, "+ REGION +" TEXT)";
        database.execSQL(tableCreation);
        addQuestions();
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldV, int newV){
        database.execSQL("DROP TABLE IF EXISTS "+ QUESTION_TABLE_NAME);
        onCreate(database);
    }

    //crud
    public void addQuestions(){
        Country q;

        //Europe
                q = new Country(1, "Igaunija","igaunija", "Eiropa");
        addCountry(q);
        q = new Country(2, "Lietuva", "lietuva", "Eiropa");
        addCountry(q);
        q = new Country(3, "Krievija", "krievija", "Eiropa");
        addCountry(q);
        q = new Country(4, "Zviedrija", "zviedrija", "Eiropa");
        addCountry(q);
        q = new Country(5, "Somija", "somija", "Eiropa");
        addCountry(q);
        q = new Country(6, "Norvēģija", "norvegija", "Eiropa");
        addCountry(q);
        q = new Country(7, "Dānija", "danija", "Eiropa");
        addCountry(q);
        q = new Country(8, "Polija", "polija", "Eiropa");
        addCountry(q);
        q = new Country(9, "Apvienotā Karaliste", "uk", "Eiropa");
        addCountry(q);
        q= new Country(10, "Spānija", "esp", "Eiropa");
        addCountry(q);
        q = new Country(11, "Portugāle", "portugal", "Eiropa");
        addCountry(q);
        q = new Country(12, "Ukraina", "ukraine", "Eiropa");
        addCountry(q);
        q = new Country(13, "Slovēnija", "slovenia", "Eiropa");
        addCountry(q);
        q = new Country(14, "Itālija", "italy", "Eiropa");
        addCountry(q);
        q = new Country(15, "Austrija", "austria", "Eiropa");
        addCountry(q);
        q = new Country(16, "Īrija", "ireland", "Eiropa");
        addCountry(q);
        q = new Country(17, "Vācija", "germany", "Eiropa");
        addCountry(q);
        q = new Country(18, "Francija", "france", "Eiropa");
        addCountry(q);
        q = new Country(19, "Horvātija", "croatia", "Eiropa");
        addCountry(q);
        q = new Country(20, "Šveice", "switzerland", "Eiropa");
        addCountry(q);
        q = new Country(21, "Vatikāns", "vatikan", "Eiropa");
        addCountry(q);
        q = new Country(22, "Beļģija", "belgium", "Eiropa");
        addCountry(q);
        q = new Country(23, "Čehija", "ch", "Eiropa");
        addCountry(q);
        q = new Country(24, "Moldova", "moldova", "Eiropa");
        addCountry(q);
        q = new Country(25, "Latvija", "latvija", "Eiropa");
        addCountry(q);
        q = new Country(26, "Rumānija", "r", "Eiropa");
        addCountry(q);
        q = new Country(27, "Serbija un Melnkalne", "sm", "Eiropa");
        addCountry(q);
        q = new Country(28, "Baltkrievija", "bk", "Eiropa");
        addCountry(q);
        q = new Country(29, "Bulgārija", "bulgarija", "Eiropa");
        addCountry(q);
        q = new Country(30, "Slovākija", "slovakia", "Eiropa");
        addCountry(q);
        q = new Country(31, "Nīderlande", "niderlande", "Eiropa");
        addCountry(q);
        q = new Country(32, "Grieķija", "greece", "Eiropa");
        addCountry(q);
        q = new Country(33, "Islande", "iceland", "Eiropa");
        addCountry(q);
        q = new Country(34, "Luksemburga", "lux", "Eiropa");
        addCountry(q);
        q = new Country(35, "Malta", "malta", "Eiropa");
        addCountry(q);
        q = new Country(36, "Ungārija", "hun", "Eiropa");
        addCountry(q);

        //Asia
        q = new Country(37, "Afganistāna", "afganistan", "Āzija");
        addCountry(q);
        q = new Country(38, "Filipīnas", "fil", "Āzija");
        addCountry(q);
        q = new Country(39, "Sīrija", "sir", "Āzija");
        addCountry(q);
        q = new Country(40, "Izrēla", "israel", "Āzija");
        addCountry(q);
        q = new Country(41, "Malaizija", "malaysia", "Āzija");
        addCountry(q);
        q = new Country(42, "Katara", "katar", "Āzija");
        addCountry(q);
        q = new Country(43, "Saūda Arābija", "sa", "Āzija");
        addCountry(q);
        q = new Country(44, "Apvienotie Arābu Emirāti", "uae", "Āzija");
        addCountry(q);
        q = new Country(45, "Ziemeļkoreja", "nk", "Āzija");
        addCountry(q);
        q = new Country(46, "Japāna", "jp", "Āzija");
        addCountry(q);
        q = new Country(47, "Dienvidkoreja", "sk", "Āzija");
        addCountry(q);
        q = new Country(48, "Vjetnama", "vj", "Āzija");
        addCountry(q);
        q = new Country(49, "Pakistāna", "pk", "Āzija");
        addCountry(q);
        q = new Country(50, "Hongkonga", "hk", "Āzija");
        addCountry(q);
        q = new Country(51, "Indija", "in", "Āzija");
        addCountry(q);
        q = new Country(52, "Indonēzija", "indonezija", "Āzija");
        addCountry(q);
        q = new Country(53, "MOngolija", "mongolija", "Āzija");
        addCountry(q);
        q = new Country(54, "Kazahstāna", "kazah", "Āzija");
        addCountry(q);
        q = new Country(55, "Irāka", "iraka", "Āzija");
        addCountry(q);
        q = new Country(56, "Kirgizstāna", "kir", "Āzija");
        addCountry(q);
        q = new Country(57, "Irāna", "iran", "Āzija");
        addCountry(q);
        q = new Country(58, "Kambodža", "cambodia", "Āzija");
        addCountry(q);
        q = new Country(59, "Azarbeidžāna", "azer", "Āzija");
        addCountry(q);
        q = new Country(60, "Ķīna", "china", "Āzija");
        addCountry(q);
        q = new Country(61, "Tiavāna", "tw", "Āzija");
        addCountry(q);
        q = new Country(62, "Singapūra", "sing", "Āzija");
        addCountry(q);
        q = new Country(63, "Turcija", "turk", "Āzija");
        addCountry(q);
        q = new Country(64, "Taizeme", "tz", "Āzija");
        addCountry(q);
        q = new Country(65, "Turkmenistāna", "turkm", "Āzija");
        addCountry(q);

        //Afrika
        q = new Country(66, "Nigērija", "nigerija", "Āfrika");
        addCountry(q);
        q = new Country(67, "Tunisija", "tun", "Āfrika");
        addCountry(q);
        q = new Country(68, "Etiopija", "etiopija", "Āfrika");
        addCountry(q);
        q = new Country(69, "somālija", "som", "Āfrika");
        addCountry(q);
        q = new Country(70, "Zimbabve", "zimbabve", "Āfrika");
        addCountry(q);
        q = new Country(71, "Zambija", "zambia", "Āfrika");
        addCountry(q);
        q = new Country(72, "Alžīrija", "alzirija", "Āfrika");
        addCountry(q);
        q = new Country(73, "Centrālāfrikas Republika", "car", "Āfrika");
        addCountry(q);
        q = new Country(74, "Ēģipte", "egypt", "Āfrika");
        addCountry(q);
        q = new Country(75, "Kongo Demokrātiskā Republika", "car", "Āfrika");
        addCountry(q);
        q = new Country(76, "Eritreja", "eritrea", "Āfrika");
        addCountry(q);
        q = new Country(77, "Sudāna", "sudan", "Āfrika");
        addCountry(q);
        q = new Country(78, "Kenija", "kenija", "Āfrika");
        addCountry(q);
        q = new Country(79, "Madagaskara", "mada", "Āfrika");
        addCountry(q);
        q = new Country(80, "Mauritānija", "mauritania", "Āfrika");
        addCountry(q);
        q = new Country(81, "DienvidĀfrikas Republika", "dar", "Āfrika");
        addCountry(q);
        q = new Country(82, "Čada", "chad", "Āfrika");
        addCountry(q);
        q = new Country(83, "Senegāla", "senegal", "Āfrika");
        addCountry(q);
        q = new Country(84, "Mozambika", "mozambika", "Āfrika");
        addCountry(q);


        //ZAmerika
        q = new Country(85, "ASV", "usa", "Ziemeļamerika");
        addCountry(q);
        q = new Country(86, "Meksika", "mexico", "Ziemeļamerika");
        addCountry(q);
        q = new Country(87, "Kanāda", "canada", "Ziemeļamerika");
        addCountry(q);
        q = new Country(88, "Bermunda", "bermunda", "Ziemeļamerika");
        addCountry(q);
        q = new Country(89, "Kuba", "kuba", "Ziemeļamerika");
        addCountry(q);
        q = new Country(90, "Gvatemala", "gva", "Ziemeļamerika");
        addCountry(q);
        q = new Country(91, "Nikaragva", "nika", "Ziemeļamerika");
        addCountry(q);
        q = new Country(92, "Panama", "panama", "Ziemeļamerika");
        addCountry(q);

        //DAmerika
        q = new Country(93, "Brazīlija", "brazil", "Dienvidamerika");
        addCountry(q);
        q = new Country(94, "Urugvaja", "urg", "Dienvidamerika");
        addCountry(q);
        q = new Country(95, "Argentīna", "argentina", "Dienvidamerika");
        addCountry(q);
        q = new Country(96, "Čīle", "chile", "Dienvidamerika");
        addCountry(q);
        q = new Country(97, "Peru", "peru", "Dienvidamerika");
        addCountry(q);
        q = new Country(98, "Bolīvija", "bolivia", "Dienvidamerika");
        addCountry(q);
        q = new Country(99, "Paragvaja", "para", "Dienvidamerika");
        addCountry(q);
        q = new Country(100, "Ekvadora", "ekva", "Dienvidamerika");
        addCountry(q);
        q = new Country(101, "Kolumbija", "kolumbija", "Dienvidamerika");
        addCountry(q);
        q = new Country(102, "Puerto Riko", "pr", "Dienvidamerika");
        addCountry(q);
        q = new Country(103, "Venecuēla", "ven", "Dienvidamerika");
        addCountry(q);

        //Australia + Okeanija
        q = new Country(104, "Austrālija", "australia", "AOk");
        addCountry(q);
        q = new Country(105, "Fidži", "fiji", "AOk");
        addCountry(q);
        q = new Country(106, "Kiribati", "kiribati", "AOk");
        addCountry(q);
        q = new Country(107, "Maršala salas", "ms", "AOk");
        addCountry(q);
        q = new Country(108, "Mikronēzija", "mic", "AOk");
        addCountry(q);
        q = new Country(109, "Nauru", "nauru", "AOk");
        addCountry(q);
        q = new Country(110, "Jaunzelande", "nz", "AOk");
        addCountry(q);
        q = new Country(111, "Palau", "pal", "AOk");
        addCountry(q);
        q = new Country(112, "Papua Jaungvijeja", "pjg", "AOk");
        addCountry(q);
        q = new Country(113, "Samoa", "samoa", "AOk");
        addCountry(q);
        q = new Country(114, "Zālamana salas", "zal", "AOk");
        addCountry(q);
        q = new Country(115, "Tonga", "tong", "AOk");
        addCountry(q);
        q = new Country(116, "Tuvalu", "tuvalu", "AOk");
        addCountry(q);
        q = new Country(117, "Vanuatu", "van", "AOk");
        addCountry(q);
    }

    public void addCountry(Country country){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(QID, country.getiD());
        values.put(COUNTRY_NAME, country.getCountryName());
        values.put(FLAG_IMAGE_NAME, country.getFlagImageName());
        values.put(REGION, country.getRegion());
        db.insert(QUESTION_TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }

    public List<Country> getAllCountries() {
        List<Country> quesList = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+QUESTION_TABLE_NAME;
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
        return quesList;
    }
}
