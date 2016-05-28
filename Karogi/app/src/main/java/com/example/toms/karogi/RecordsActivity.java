package com.example.toms.karogi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class RecordsActivity extends Activity{
    ImageButton goHome;
    TextView record;
    int rec; // holds record from db
    DatabaseHandler databaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_record);

        record = (TextView) findViewById(R.id.rekords);
        databaseHandler = new DatabaseHandler(this);
        rec = databaseHandler.getRecord(); //gets record from db
        record.setText("Augstākais rezultāts: "+ Integer.toString(rec));

        goHome = (ImageButton) findViewById(R.id.imageButton_uz_izvelniR);
        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecordsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
