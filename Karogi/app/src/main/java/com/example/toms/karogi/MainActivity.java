package com.example.toms.karogi;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends Activity {

    ImageButton button_5;
    ImageButton button_10;
    ImageButton button_15;
    ImageButton button_20;
    ImageButton button_50;
    ImageButton visasValstis;
    ImageButton afrika;
    ImageButton australijaUnOkeanija;
    ImageButton ziemelAmerika;
    ImageButton azija;
    ImageButton dienvidAmerika;
    ImageButton eiropa;
    ImageButton rekordi;
    ImageButton sakt;

    /*
    DatabaseHandler databaseHandler;
    int countafrika;
    int countaok;
    int countzamerika;
    int countdamerika;
    int counteiropa;
    int countazija;
    */

    boolean btn5, btn10, btn15, btn20, btn50 = false;
    boolean btnVisasValstis, btnAfrika, btnAustralijaUnOkeanija, btnZiemelAmerika, btnAzija, btnDienvidAmerika, btnEiropa = false;
    boolean saktIsActive = false;
    int questionCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        /*
        databaseHandler = new DatabaseHandler(this);
        countafrika = databaseHandler.getAfrikaCountryCount();
        countaok = databaseHandler.getAustralijaOkeanijaCountryCount();
        countzamerika = databaseHandler.getZAmerikaCountryCount();
        countdamerika = databaseHandler.getDAmerikaCountryCount();
        counteiropa = databaseHandler.getEuropeCountryCount();
        countazija = databaseHandler.getAzijaCountryCount();
        */

        addListenersForMenuButtons();
        addListenersOnNumberButtons();
        addListenersForAreaButtons();

    }
    private boolean evaluateSakt(){
        saktIsActive = (btn5 || btn10 || btn15 || btn20 || btn50) && (btnVisasValstis || btnAfrika || btnAustralijaUnOkeanija || btnZiemelAmerika || btnAzija || btnDienvidAmerika || btnEiropa);
        return saktIsActive;
    }

    private String[] evaluateRegions(){
        String[] regions = new String[]{"visasValstisOff", "afrikaOff", "australijaUnOkeanijaOff", "ziemelAmerikaOff", "azijaOff", "dienvidAmerikaOff", "eiropaOff"};
        if(btnVisasValstis){
            regions[0] = "visasValstisOn";
            regions[1] = "afrikaOn";
            regions[2] = "australijaUnOkeanijaOn";
            regions[3] = "ziemelAmerikaOn";
            regions[4] = "azijaOn";
            regions[5] = "dienvidAmerikaOn";
            regions[6] = "eiropaOn";
            return regions;
        }
        if(btnAfrika)regions[1] = "afrikaOn";
        if(btnAustralijaUnOkeanija) regions[2] = "australijaUnOkeanijaOn";
        if(btnZiemelAmerika) regions[3] = "ziemelAmerikaOn";
        if(btnAzija) regions[4] = "azijaOn";
        if(btnDienvidAmerika) regions[5] = "dienvidAmerikaOn";
        if(btnEiropa) regions[6] = "eiropaOn";
        return regions;
    }

    private void saktBackgroundCheck(){
        if(evaluateSakt()) sakt.setBackgroundResource(R.drawable.sakt_active);
        else sakt.setBackgroundResource(R.drawable.sakt_unactive);
    }

    private int evaluateQuestionCount(){
        if(btn5){
            questionCount = 5; return questionCount;
        }
        else if(btn10){
            questionCount = 10; return questionCount;
        }
        else if(btn15){
            questionCount = 15; return questionCount;
        }
        else if (btn20){
            questionCount = 20; return questionCount;
        }
        else if(btn50){
            questionCount = 50; return questionCount;
        }
        return 0;
    }

    public void addListenersForMenuButtons(){
        rekordi = (ImageButton) findViewById(R.id.imageButton_rekordi);
        sakt = (ImageButton) findViewById(R.id.imageButton_sakt);

        rekordi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //taketh you to records
            }
        });

        sakt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(evaluateSakt()){
                    //goes to quiz
                    Intent intent = new Intent(MainActivity.this, QuestionsActivity.class);
                    intent.putExtra("questionCount", evaluateQuestionCount());
                    intent.putExtra("regions", evaluateRegions());
                    startActivity(intent);
                }
                else{
                    //show toast
                    Toast.makeText(MainActivity.this, "Izvēlies jautājumu skaitu un valstu reģionu",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void addListenersForAreaButtons() {
        visasValstis = (ImageButton) findViewById(R.id.imageButton_visas_valstis);
        afrika = (ImageButton) findViewById(R.id.imageButton_afrika);
        australijaUnOkeanija = (ImageButton) findViewById(R.id.imageButton_australija_un_okeanija);
        ziemelAmerika = (ImageButton) findViewById(R.id.imageButton_ziemel_amerika);
        azija = (ImageButton) findViewById(R.id.imageButton_azija);
        dienvidAmerika = (ImageButton) findViewById(R.id.imageButton_dienvid_amerika);
        eiropa = (ImageButton) findViewById(R.id.imageButton_eiropa);

        visasValstis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!btnVisasValstis) {
                    visasValstis.setBackgroundResource(R.drawable.visas_valstis_selected);
                    afrika.setBackgroundResource(R.drawable.afrika_selected);
                    australijaUnOkeanija.setBackgroundResource(R.drawable.australija_un_okeanija_selected);
                    ziemelAmerika.setBackgroundResource(R.drawable.ziemel_amerika_selected);
                    azija.setBackgroundResource(R.drawable.azija_selected);
                    dienvidAmerika.setBackgroundResource(R.drawable.dienvid_amerika_selected);
                    eiropa.setBackgroundResource(R.drawable.eiropa_selected);

                    btnVisasValstis = true;
                    btnAfrika = true;
                    btnAustralijaUnOkeanija = true;
                    btnZiemelAmerika = true;
                    btnAzija = true;
                    btnDienvidAmerika = true;
                    btnEiropa = true;

                    saktBackgroundCheck();
                }
                else {
                    visasValstis.setBackgroundResource(R.drawable.visas_valstis_unselected);
                    afrika.setBackgroundResource(R.drawable.afrika_unselected);
                    australijaUnOkeanija.setBackgroundResource(R.drawable.australija_un_okeanija_unselected);
                    ziemelAmerika.setBackgroundResource(R.drawable.ziemel_amerika_unselected);
                    azija.setBackgroundResource(R.drawable.azija_unselected);
                    dienvidAmerika.setBackgroundResource(R.drawable.dienvid_amerika_unselected);
                    eiropa.setBackgroundResource(R.drawable.eiropa_unselected);

                    btnVisasValstis = false;
                    btnAfrika = false;
                    btnAustralijaUnOkeanija = false;
                    btnZiemelAmerika = false;
                    btnAzija = false;
                    btnDienvidAmerika = false;
                    btnEiropa = false;

                    saktBackgroundCheck();
                }
            }
        });
        afrika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnAfrika == false){
                    afrika.setBackgroundResource(R.drawable.afrika_selected);
                    btnAfrika = true;
                    if((btnAfrika && btnAustralijaUnOkeanija && btnZiemelAmerika && btnAzija && btnDienvidAmerika && btnEiropa) == true){
                        visasValstis.setBackgroundResource(R.drawable.visas_valstis_selected);
                        btnVisasValstis = true;
                    }
                    saktBackgroundCheck();
                }
                else{
                    afrika.setBackgroundResource(R.drawable.afrika_unselected);
                    btnAfrika = false;
                    if(btnVisasValstis) {
                        visasValstis.setBackgroundResource(R.drawable.visas_valstis_unselected);
                        btnVisasValstis = false;
                    }
                    saktBackgroundCheck();
                }
            }
        });

        australijaUnOkeanija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnAustralijaUnOkeanija == false){
                    australijaUnOkeanija.setBackgroundResource(R.drawable.australija_un_okeanija_selected);
                    btnAustralijaUnOkeanija = true;
                    if((btnAfrika && btnAustralijaUnOkeanija && btnZiemelAmerika && btnAzija && btnDienvidAmerika && btnEiropa) == true){
                        visasValstis.setBackgroundResource(R.drawable.visas_valstis_selected);
                        btnVisasValstis = true;
                    }
                    saktBackgroundCheck();
                }
                else{
                    australijaUnOkeanija.setBackgroundResource(R.drawable.australija_un_okeanija_unselected);
                    btnAustralijaUnOkeanija = false;
                    if(btnVisasValstis) {
                        visasValstis.setBackgroundResource(R.drawable.visas_valstis_unselected);
                        btnVisasValstis = false;
                    }
                    saktBackgroundCheck();
                }
            }
        });

        ziemelAmerika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnZiemelAmerika == false){
                    ziemelAmerika.setBackgroundResource(R.drawable.ziemel_amerika_selected);
                    btnZiemelAmerika = true;
                    if((btnAfrika && btnAustralijaUnOkeanija && btnZiemelAmerika && btnAzija && btnDienvidAmerika && btnEiropa) == true){
                        visasValstis.setBackgroundResource(R.drawable.visas_valstis_selected);
                        btnVisasValstis = true;
                    }
                    saktBackgroundCheck();
                }
                else{
                    ziemelAmerika.setBackgroundResource(R.drawable.ziemel_amerika_unselected);
                    btnZiemelAmerika = false;
                    if(btnVisasValstis) {
                        visasValstis.setBackgroundResource(R.drawable.visas_valstis_unselected);
                        btnVisasValstis = false;
                    }
                    saktBackgroundCheck();
                }
            }
        });

        azija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnAzija == false){
                    azija.setBackgroundResource(R.drawable.azija_selected);
                    btnAzija = true;
                    if((btnAfrika && btnAustralijaUnOkeanija && btnZiemelAmerika && btnAzija && btnDienvidAmerika && btnEiropa) == true){
                        visasValstis.setBackgroundResource(R.drawable.visas_valstis_selected);
                        btnVisasValstis = true;
                    }
                    saktBackgroundCheck();
                }
                else{
                    azija.setBackgroundResource(R.drawable.azija_unselected);
                    btnAzija = false;
                    if(btnVisasValstis) {
                        visasValstis.setBackgroundResource(R.drawable.visas_valstis_unselected);
                        btnVisasValstis = false;
                    }
                    saktBackgroundCheck();
                }
            }
        });

        dienvidAmerika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnDienvidAmerika == false){
                    dienvidAmerika.setBackgroundResource(R.drawable.dienvid_amerika_selected);
                    btnDienvidAmerika = true;
                    if((btnAfrika && btnAustralijaUnOkeanija && btnZiemelAmerika && btnAzija && btnDienvidAmerika && btnEiropa) == true){
                        visasValstis.setBackgroundResource(R.drawable.visas_valstis_selected);
                        btnVisasValstis = true;
                    }
                    saktBackgroundCheck();
                }
                else{
                    dienvidAmerika.setBackgroundResource(R.drawable.dienvid_amerika_unselected);
                    btnDienvidAmerika = false;
                    if(btnVisasValstis) {
                        visasValstis.setBackgroundResource(R.drawable.visas_valstis_unselected);
                        btnVisasValstis = false;
                    }
                    saktBackgroundCheck();
                }
            }
        });

        eiropa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnEiropa == false){
                    eiropa.setBackgroundResource(R.drawable.eiropa_selected);
                    btnEiropa = true;
                    if((btnAfrika && btnAustralijaUnOkeanija && btnZiemelAmerika && btnAzija && btnDienvidAmerika && btnEiropa) == true){
                        visasValstis.setBackgroundResource(R.drawable.visas_valstis_selected);
                        btnVisasValstis = true;
                    }
                    saktBackgroundCheck();
                }
                else{
                    eiropa.setBackgroundResource(R.drawable.eiropa_unselected);
                    btnEiropa = false;
                    if(btnVisasValstis) {
                        visasValstis.setBackgroundResource(R.drawable.visas_valstis_unselected);
                        btnVisasValstis = false;
                    }
                    saktBackgroundCheck();
                }
            }
        });
    }

    public void addListenersOnNumberButtons() {
        button_5 = (ImageButton) findViewById(R.id.imageButton_5);
        button_10 = (ImageButton) findViewById(R.id.imageButton_10);
        button_15 = (ImageButton) findViewById(R.id.imageButton_15);
        button_20 = (ImageButton) findViewById(R.id.imageButton_20);
        button_50 = (ImageButton) findViewById(R.id.imageButton_50);

        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn5 = true;
                btn10 = false;
                btn15 = false;
                btn20 = false;
                btn50 = false;
                button_5.setBackgroundResource(R.drawable.i5_selected);
                button_10.setBackgroundResource(R.drawable.i10_unselected);
                button_15.setBackgroundResource(R.drawable.i15_unselected);
                button_20.setBackgroundResource(R.drawable.i20_unselected);
                button_50.setBackgroundResource(R.drawable.i50_unselected);

                saktBackgroundCheck();
            }
        });

        button_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn5 = false;
                btn10 = true;
                btn15 = false;
                btn20 = false;
                btn50 = false;
                button_5.setBackgroundResource(R.drawable.i5_unselected);
                button_10.setBackgroundResource(R.drawable.i10_selected);
                button_15.setBackgroundResource(R.drawable.i15_unselected);
                button_20.setBackgroundResource(R.drawable.i20_unselected);
                button_50.setBackgroundResource(R.drawable.i50_unselected);
                saktBackgroundCheck();
            }
        });

        button_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn5 = false;
                btn10 = false;
                btn15 = true;
                btn20 = false;
                btn50 = false;
                button_5.setBackgroundResource(R.drawable.i5_unselected);
                button_10.setBackgroundResource(R.drawable.i10_unselected);
                button_15.setBackgroundResource(R.drawable.i15_selected);
                button_20.setBackgroundResource(R.drawable.i20_unselected);
                button_50.setBackgroundResource(R.drawable.i50_unselected);
                saktBackgroundCheck();
            }
        });

        button_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn5 = false;
                btn10 = false;
                btn15 = false;
                btn20 = true;
                btn50 = false;
                button_5.setBackgroundResource(R.drawable.i5_unselected);
                button_10.setBackgroundResource(R.drawable.i10_unselected);
                button_15.setBackgroundResource(R.drawable.i15_unselected);
                button_20.setBackgroundResource(R.drawable.i20_selected);
                button_50.setBackgroundResource(R.drawable.i50_unselected);
                saktBackgroundCheck();
            }
        });

        button_50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn5 = false;
                btn10 = false;
                btn15 = false;
                btn20 = false;
                btn50 = true;
                button_5.setBackgroundResource(R.drawable.i5_unselected);
                button_10.setBackgroundResource(R.drawable.i10_unselected);
                button_15.setBackgroundResource(R.drawable.i15_unselected);
                button_20.setBackgroundResource(R.drawable.i20_unselected);
                button_50.setBackgroundResource(R.drawable.i50_selected);
                saktBackgroundCheck();
            }
        });

    }


}
