package com.example.ginrummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class Scoreboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        Intent i = getIntent();
        //Create new game
        //String result = i.getStringExtra("ginRummy");


        //Create new game
        GinDemo gd = (GinDemo) i.getSerializableExtra("gr");

        //ScrollView scrollScore = findViewById(R.id.dataScrollView);
        TextView scroll = findViewById(R.id.scoreDisplay);

        scroll.setText(gd.getScoreResults());
    }
}