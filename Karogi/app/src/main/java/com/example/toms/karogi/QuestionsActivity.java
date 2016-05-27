package com.example.toms.karogi;

import android.app.Activity;
import android.os.Bundle;

import java.util.List;

import android.widget.ImageButton;
import android.widget.TextView;

public class QuestionsActivity extends Activity {
    List<Country>countryList;
    int score = 0;
    int qid = 0;
    Country currentCountry;
    TextView txtCountry;
    ImageButton btnA;
    ImageButton btnB;
    ImageButton btnC;
    ImageButton btnD;
    ImageButton btnPartraukt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        //databaseHandler.addQuestions();
        countryList = databaseHandler.getAllCountries(); //todo maketh it so that countries from selected regions be given

        txtCountry = (TextView) findViewById(R.id.valstsNosaukums);
        btnA = (ImageButton) findViewById(R.id.imageButton_firstOption);
        btnB = (ImageButton) findViewById(R.id.imageButton_secondOption);
        btnC = (ImageButton) findViewById(R.id.imageButton_thirdOption);
        btnD = (ImageButton) findViewById(R.id.imageButton_forthOption);
        btnPartraukt = (ImageButton) findViewById(R.id.imageButton_partraukt);
        setQuestionView();
    }
    private void setQuestionView(){
        //puts stuff together
        currentCountry = countryList.get(qid); //todo maketh it so that random country be given
        txtCountry.setText(currentCountry.getCountryName());
        int resIdA = getResources().getIdentifier(currentCountry.getFlagImageName(), "drawable", getPackageName());
        btnA.setBackgroundResource(resIdA);
        int resIdB = getResources().getIdentifier("latvia", "drawable", getPackageName());
        btnB.setBackgroundResource(resIdB);
        int resIdC = getResources().getIdentifier("lithuania", "drawable", getPackageName());
        btnC.setBackgroundResource(resIdC);
        int resIdD = getResources().getIdentifier("russia", "drawable", getPackageName());
        btnD.setBackgroundResource(resIdD);
    }

}
