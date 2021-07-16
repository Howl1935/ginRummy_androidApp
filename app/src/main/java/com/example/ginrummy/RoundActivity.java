package com.example.ginrummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class RoundActivity extends AppCompatActivity {

    private GinDemo gd;     //current populated game object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

        Intent i = getIntent();

        //Create new game
        this.gd = (GinDemo) i.getSerializableExtra("gin");

        //display the current round number
        TextView roundNumber = findViewById(R.id.roundTextVariable);
        String rNum = "Round #" + gd.getRound();
        roundNumber.setText(rNum);

        //display the current game #
        TextView gameNumber = findViewById(R.id.gameTextVariable);
        String gNum = "Game #" + gd.getGameNum();
        gameNumber.setText(gNum);

        //display player 1's name
        TextView p1 = findViewById(R.id.p1NameText);
        p1.setText(gd.getPlayer1());

        //display player 1's score
        TextView p1Score = findViewById(R.id.p1ScoreDisplay);
        p1Score.setText(gd.getPlayer1Score());

        //display player 2's name
        TextView p2 = findViewById(R.id.p2NameText);
        p2.setText(gd.getPlayer2());

        //display player 2's score
        TextView p2Score = findViewById(R.id.p2ScoreDisplay);
        p2Score.setText(gd.getPlayer2Score());

    }
    //options button onClick method, options options activity
    public void clickOptions(View v){
        Intent i = new Intent(this, GameOptions.class);
        i.putExtra("gr", this.gd);
        startActivity(i);
    }
    public void clickTally(View v) {
        TextView p1Input = findViewById(R.id.p1RoundInput);
        TextView p2Input = findViewById(R.id.p2RoundInput);

        //error checking
        if(p1Input.getText().toString().equals("")) {
            p1Input.setError("Enter valid score");

            Log.d("emptyBox", "is empty");
        }else if(p2Input.getText().toString().equals(""))
        {
            p1Input.setError("Enter valid score");
        }
        else if(gd.tallyRound(Integer.parseInt(p1Input.getText().toString()), Integer.parseInt(p2Input.getText().toString())))
        {
            //this means our points have crossed the point thresh hold
            Log.d("pass100", gd.getWinner());

            //create intent
            Intent i = new Intent(this, Scoreboard.class );

            //pass object
            i.putExtra("gr", this.gd);
            startActivity(i);


            //this should happen when we get back from scoreBoard
            //increment the game count
            gd.incrementGameCount();
            //create a new game file
            gd.newGame();

            TextView p1Score = findViewById(R.id.p1ScoreDisplay);
            p1Score.setText(gd.getPlayer1Score());
            TextView p2Score = findViewById(R.id.p2ScoreDisplay);
            p2Score.setText(gd.getPlayer2Score());

            //clear inputs
            p1Input.setText("");
            p2Input.setText("");

            TextView gameNumber = findViewById(R.id.gameTextVariable);
            String gNum = "Game #" + gd.getGameNum();
            gameNumber.setText(gNum);

            TextView roundNumber = findViewById(R.id.roundTextVariable);
            String rNum = "Round #" + gd.getRound();
            roundNumber.setText(rNum);



        }else
        {

            TextView p1Score = findViewById(R.id.p1ScoreDisplay);
           p1Score.setText(gd.getPlayer1Score());
           p1Input.setText("");

            TextView p2Score = findViewById(R.id.p2ScoreDisplay);
            p2Score.setText(gd.getPlayer2Score());
            p2Input.setText("");

            TextView roundNumber = findViewById(R.id.roundTextVariable);
            String rNum = "Round #" + gd.getRound();
            roundNumber.setText(rNum);
        }

    }
}