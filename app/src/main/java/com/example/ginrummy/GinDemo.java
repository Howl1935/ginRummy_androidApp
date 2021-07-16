package com.example.ginrummy;

import android.annotation.SuppressLint;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

public class GinDemo implements Serializable {

    private String fname;       //filename of current game
    private String player1;     //player one's name
    private String player2;     //player two's name
    private int numGames;       //number of games this game will go for (ex: best 2/3)
    private int numPoints;      //number of points each game runs until
    private int gameCount;      //keeps track of which game we are currently on, default 1
    private ArrayList<GameData> games;

    public GinDemo(String fname) {
        //add code to open and populate class from file here
    }

    public GinDemo(String fname, String player1, String player2, int numGames, int numPoints) {
        this.fname = fname;
        this.player1 = player1;
        this.player2 = player2;
        this.numGames = numGames;
        this.numPoints = numPoints;
        this.gameCount = 0;
        this.games = new ArrayList<>();
        this.games.add(new GameData(1));    //create the first game
    }

    public void saveGame() throws IOException {
        FileOutputStream fos = null;


    }

    public ArrayList<GameData> getGameData()
    {
        return this.games;
    }
    public String getPlayer1() {
        return this.player1;
    }
    public String getPlayer1Score() {
        return String.valueOf(this.games.get(this.gameCount).getP1RunningPoints());
    }


    public String getPlayer2()
    {
        return this.player2;
    }
    public String getPlayer2Score()
    {
        return String.valueOf(this.games.get(this.gameCount).getP2RunningPoints());

    }
    //returns current round
    public String getRound()
    {
     return String.valueOf(this.games.get(gameCount).getRound()+1);
    }
    public String getGameNum()
    {
        return String.valueOf(gameCount+1);
    }
    public boolean tallyRound(int p1Points, int p2Points)
    {
        this.games.get(gameCount).tallyRound(p1Points, p2Points);
        return (this.games.get(gameCount).p1Crossed100() || this.games.get(gameCount).p2Crossed100());
    }
    public void incrementGameCount()
    {
        this.gameCount++;
    }

    public String getWinner()
    {
        return this.games.get(gameCount).getWinner();
    }
    public void newGame()
    {
        this.games.add(new GameData(gameCount+1));
    }
    public String getScoreResults()
    {
        String result = "";
        //StringBuilder sb = new StringBuilder();
        //go through all games
        for(int i=gameCount+1; i > 0; i--)
        {   //sb.append(this.player1 + "                              " + this.player2 +"\n\n");
            //result += this.player1 + "<-->\t" + this.player2 +"\n\n";
            //result += g.getRoundString();

            result += String.format("        %s                %s\n                Game %d\n\n %s\n", player1, player2, i, this.games.get(i-1).getRoundString());

            //sb.append(g.getRoundString());
            result += "Winner: " + this.games.get(i-1).getWinner() ;
        }
        result += "\n";
        //sb.append("\n");
        //return sb.toString();
        return result;
    }
    public String getFname()
    {
        return this.fname + ".txt";
    }


}
