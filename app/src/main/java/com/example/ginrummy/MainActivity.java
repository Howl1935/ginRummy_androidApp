package com.example.ginrummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadFile(View v){
        Intent i = new Intent(this, LoadActivity.class);
        startActivity(i);
    }
    public void clickNewButton(View v)
    {
        Intent i = new Intent(this, NewGame.class);
        startActivity(i);
    }

    public void clickHighScoreButton(View v)
    {
        Toast.makeText(this,
                "This a toast message",
                Toast.LENGTH_LONG).show();

    }



}