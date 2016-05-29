package com.example.toms.karogi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends Activity {
    List<Country>countryList = new ArrayList<>();;
    int score = 0;
    int currentQuestion = 0;
    int qcount; //the selected question count by user
    int countriesInRegions;
    String [] regions;
   // int[] countriesAsked; //arr of country iDs, that have already been asked to answer
    Country trueCountry;
    TextView txtCountry;
    TextView currQ;
    ImageButton btnA;
    ImageButton btnB;
    ImageButton btnC;
    ImageButton btnD;
    ImageButton[] imgBArr;
    ImageButton btnPartraukt;
    DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        qcount = getIntent().getExtras().getInt("questionCount");  //retrieves the question count
       // countriesAsked = new int[qcount]; //sets the aswer array size

        regions = getIntent().getExtras().getStringArray("regions"); //string arr containing user made region selection
        databaseHandler = new DatabaseHandler(this);
        countryList = setSelectedCountryList(regions); //only countries from selected regions are given
        Collections.shuffle(countryList); //shuffles thou list

        calcRegionCountryCount();


        txtCountry = (TextView) findViewById(R.id.valstsNosaukums);
        currQ = (TextView) findViewById(R.id.currentQ);
        addListenersForButtons();

        imgBArr = new ImageButton[]{btnA, btnB, btnC, btnD};
        setQuestionView();
    }

    private void calcRegionCountryCount(){
        if(regions[0].equals("visasValstisOn")) {
            countriesInRegions = databaseHandler.getAfrikaCountryCount() + databaseHandler.getAustralijaOkeanijaCountryCount()+databaseHandler.getAzijaCountryCount()+databaseHandler.getDAmerikaCountryCount()+databaseHandler.getZAmerikaCountryCount()+databaseHandler.getEuropeCountryCount();
            return;
        }
        if(regions[1].equals("afrikaOn")) countriesInRegions += databaseHandler.getAfrikaCountryCount();
        if(regions[2].equals("australijaUnOkeanijaOn")) countriesInRegions += databaseHandler.getAustralijaOkeanijaCountryCount();
        if(regions[3].equals("ziemelAmerikaOn")) countriesInRegions += databaseHandler.getZAmerikaCountryCount();
        if(regions[4].equals("azijaOn")) countriesInRegions += databaseHandler.getAzijaCountryCount();
        if(regions[5].equals("dienvidAmerikaOn")) countriesInRegions += databaseHandler.getDAmerikaCountryCount();
        if(regions[6].equals("eiropaOn")) countriesInRegions += databaseHandler.getEuropeCountryCount();
        return;
    }

    private void addListenersForButtons(){
        btnA = (ImageButton) findViewById(R.id.imageButton_firstOption);
        btnB = (ImageButton) findViewById(R.id.imageButton_secondOption);
        btnC = (ImageButton) findViewById(R.id.imageButton_thirdOption);
        btnD = (ImageButton) findViewById(R.id.imageButton_forthOption);
        btnPartraukt = (ImageButton) findViewById(R.id.imageButton_partraukt);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(btnA.getTag());

            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v){
                getAnswer(btnB.getTag());

            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(btnC.getTag());
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v){
                getAnswer(btnD.getTag());
            }
        });

        btnPartraukt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void getAnswer(Object object){
        int tag = (int)object;

        if(tag == 1) {
            score++;
            if(currentQuestion != qcount && currentQuestion != countryList.size()) {
                setQuestionView();
            }
            else {
                //taketh you to rezults
                Intent intent = new Intent(QuestionsActivity.this, RezultsActivity.class);
                intent.putExtra("score", score);
                intent.putExtra("questions", qcount);
                intent.putExtra("regions", regions);
                startActivity(intent);
            }
        }
        else {
            //Toast.makeText(QuestionsActivity.this, "Nepareiza atbilde", Toast.LENGTH_SHORT).show();
            final Toast toast = Toast.makeText(QuestionsActivity.this, "Nepareiza atbilde", Toast.LENGTH_SHORT);
            toast.show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toast.cancel();
                }
            }, 100); //1000 ms = 1 sec
            if(currentQuestion != qcount && currentQuestion != countryList.size()) {
                setQuestionView();
            }
            else {
                //taketh you to rezults
                Intent intent = new Intent(QuestionsActivity.this, RezultsActivity.class);
                intent.putExtra("score", score);
                intent.putExtra("questions", qcount);
                intent.putExtra("regions", regions);
                startActivity(intent);
            }
        }
    }

    private int[] getRandomNumberArr(int max, int size){ //max - maximum value, size - size of arr that be returned
        //returned arr gots unique ints
        int []rez = new  int[max];
        for (int a = 0; a<max; a++){
            rez[a] = a;
        }
        shuffleArray(rez);
        int []rez1 = new int [size];
        if(size <= max){
            for (int a=0; a<size; a++){
                rez1[a] = rez[a];
            }
            return rez1;
        }
        else
        return rez1;
    }

    private void shuffleArray(int[] array)
    {
        int index;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            if (index != i)
            {
                array[index] ^= array[i];
                array[i] ^= array[index];
                array[index] ^= array[i];
            }
        }
    }

    private boolean arrHasNumber(int[] a, int key){
        for (int number : a){
            if(number == key) return true;
        }
        return false;
    }


    private List<Country> setSelectedCountryList(String[] regions){
        List<Country> countryList = new ArrayList<>();

        if(regions[0].equals("visasValstisOn")){
            countryList.addAll(databaseHandler.getAllCountries());
            return countryList;
        }
        if(regions[1].equals("afrikaOn")){
            countryList.addAll(databaseHandler.getAllCountriesAfrica());
        }
        if(regions[2].equals("australijaUnOkeanijaOn")){
            countryList.addAll(databaseHandler.getAllCountriesAustralijaOkeanija());
        }
        if(regions[3].equals("ziemelAmerikaOn")){
            countryList.addAll(databaseHandler.getAllCountriesZAmerika());
        }
        if(regions[4].equals("azijaOn")){
            countryList.addAll(databaseHandler.getAllCountriesAzija());
        }
        if(regions[5].equals("dienvidAmerikaOn")){
            countryList.addAll(databaseHandler.getAllCountriesDAmerika());
        }
        if(regions[6].equals("eiropaOn")){
            countryList.addAll(databaseHandler.getAllCountriesEiropa());
        }
        return countryList;
    }

    private void setQuestionView(){
        //puts stuff together
        int [] arr = new int[]{0, 1, 2, 3}; //for buttons
        shuffleArray(arr); //maketh button order random in nature
        int [] countriesIndex;
        do {
            countriesIndex = getRandomNumberArr(countryList.size(), 3); //gets 3 unique random numbers for countries
        }while (arrHasNumber(countriesIndex, currentQuestion));

        trueCountry = countryList.get(currentQuestion); //random country be given, because list is random
        Country falseCountry1 = countryList.get(countriesIndex[0]);
        Country falseCountry2 = countryList.get(countriesIndex[1]);
        Country falseCountry3 = countryList.get(countriesIndex[2]);
        currentQuestion++;

        int temp;
        if(countriesInRegions < qcount) {
            temp = countriesInRegions;
        }
            else temp = qcount;

        txtCountry.setText(trueCountry.getCountryName()); //maketh textview
        currQ.setText(Integer.toString(currentQuestion)+" / "+Integer.toString(temp));
        int resIdA = getResources().getIdentifier(trueCountry.getFlagImageName(), "drawable", getPackageName());
        int resIdB = getResources().getIdentifier(falseCountry1.getFlagImageName(), "drawable", getPackageName());
        int resIdC = getResources().getIdentifier(falseCountry2.getFlagImageName(), "drawable", getPackageName());
        int resIdD = getResources().getIdentifier(falseCountry3.getFlagImageName(), "drawable", getPackageName());

        imgBArr[arr[0]].setBackgroundResource(resIdA); //always the correct one, but always a different button
        imgBArr[arr[1]].setBackgroundResource(resIdB); //always the incorrect one, but always a different button
        imgBArr[arr[2]].setBackgroundResource(resIdC); //always the incorrect one, but always a different button
        imgBArr[arr[3]].setBackgroundResource(resIdD); //always the incorrect one, but always a different button

        imgBArr[arr[0]].setTag(1);
        imgBArr[arr[1]].setTag(0);
        imgBArr[arr[2]].setTag(0);
        imgBArr[arr[3]].setTag(0);

    }

}
