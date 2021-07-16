package com.example.ginrummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GameOptions extends AppCompatActivity {
    private GinDemo gd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_options);
        Intent i = getIntent();

        this.gd = (GinDemo)i.getSerializableExtra("gr");
    }
    public void clickQuitNoSave(View v){
        //exit program
        this.finishAffinity();
        System.exit(0);
    }
    public void clickQuitSave(View v){
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(this.gd.getFname(), MODE_PRIVATE);
            fos.write(this.gd.getFname().getBytes());
            fos.write(this.gd.getPlayer1().getBytes());
            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + this.gd.getFname(), Toast.LENGTH_LONG).show();
            Log.d("saved", "Saved to " + getFilesDir() + "/" + this.gd.getFname());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void clickScoreboard(View v){
        Intent i = new Intent(this, Scoreboard.class);
        i.putExtra("gr", this.gd);
        startActivity(i);
    }


}