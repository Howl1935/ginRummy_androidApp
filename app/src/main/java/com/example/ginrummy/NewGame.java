package com.example.ginrummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NewGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
    }

    public void clickGo(View v) {

        boolean errorChecked = true;
        //save the filename input as a variable
        EditText fInput = findViewById(R.id.saveFileInput);
        String fname = fInput.getText().toString().toLowerCase();

        //error check fname
        if (fInput.getText().toString().equals("") || fname.matches("[^a-zA-Z0-9]") || fname.contains(".") || fname.contains(" ")|| fname.contains("?")) {
            errorChecked = false;
            fInput.setError("Please enter valid save name (letters and numbers only)");
        }
        //save the player1 input name
        EditText p1Input = findViewById(R.id.player1Input);
        String p1Name = p1Input.getText().toString();

        //error check player1 input
        if (p1Input.getText().toString().equals("")) {
            errorChecked = false;
            p1Input.setError("Please enter Player 1 name");
        }

        //save the player2 input name
        EditText p2Input = findViewById(R.id.player2Input);
        String p2Name = p2Input.getText().toString();

        //error check player2 input
        if (p2Input.getText().toString().equals("")) {
            errorChecked = false;
            p2Input.setError("Please enter Player 2 name");
        }
        //get number of rounds as an int
        EditText numRoundsInput = findViewById(R.id.roundsInput);
        int numRounds = Integer.parseInt(numRoundsInput.getText().toString());

        //error check number of rounds input
        if(numRounds < -1 || numRounds == 0)
        {
            errorChecked = false;
            p2Input.setError("Please enter rounds greater than 0 or -1 for infinite rounds");
        }

        if(errorChecked){
            GinDemo gd = new GinDemo(fname, p1Name, p2Name, numRounds, 100);

            //create intent
            Intent i = new Intent(this, RoundActivity.class );
            //now pass gd to intent
            i.putExtra("gin", gd);
            startActivity(i);
        }

    }

}