package com.example.toms.karogi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class RezultsActivity extends Activity {

    TextView pareiziAtbJaut;
    TextView precizitate;
    TextView punkti;
    TextView augstakaisRezultats;
    ImageButton atkartot;
    ImageButton uzIzvelni;
    double score;
    int total;
    double precizion;
    int points;
    int record;
    String[] regions;
    DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_rezults);
        score = getIntent().getExtras().getInt("score");  //retrieves the score
        total = getIntent().getExtras().getInt("questions");  //retrieves the score
        pareiziAtbJaut = (TextView) findViewById(R.id.pareiziatbildetiejaut);
        pareiziAtbJaut.setText("Pareizi atbildētie jautājumi: " + Integer.toString((int) score) + "/" + Integer.toString(total));

        precizitate = (TextView) findViewById(R.id.precizitate);
        precizion = score/total*100;
        precizitate.setText("Precizitāte: " + Integer.toString((int) (precizion)) + "%");
        punkti = (TextView) findViewById(R.id.punkti);
        points = (int)score*10;
        punkti.setText("Punkti: "+Integer.toString(points));

        databaseHandler = new DatabaseHandler(this);

       // databaseHandler.addRecord(Integer.toString(points));
        augstakaisRezultats = (TextView) findViewById(R.id.augstakaisrezultats);
        record = Integer.parseInt(databaseHandler.getRecord());
        if(record < points) {
            databaseHandler.addRecord(Integer.toString(points));
            augstakaisRezultats.setText("Augstākais rezultāts: " + Integer.toString(points));
        }
        else augstakaisRezultats.setText("Augstākais rezultāts: "+record);


        regions = getIntent().getExtras().getStringArray("regions");
        atkartot = (ImageButton) findViewById(R.id.imageButton_atkartot);
        atkartot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RezultsActivity.this, QuestionsActivity.class);
                intent.putExtra("questionCount", total);
                intent.putExtra("regions", regions);
                startActivity(intent);
            }
        });

        uzIzvelni = (ImageButton) findViewById(R.id.imageButton_uz_izvelni);
        uzIzvelni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RezultsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
