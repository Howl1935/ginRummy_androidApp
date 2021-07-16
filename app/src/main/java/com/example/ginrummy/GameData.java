package com.example.ginrummy;

import android.annotation.SuppressLint;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The GameData class holds all the data for one game of Gin Rummy.  This includes the current game ID,
 * the total running points for p1, p2, who is in the current lead for the game and the data for each round
 */
public class GameData implements Serializable {
    private int gameId;
    private int p1RunningPoints;
    private int p2RunningPoints;
    private ArrayList<Round> rounds;
    private player currentLead;

    //enumerate players
    private enum player {
        PLAYER_ONE,
        PLAYER_TWO,
        TIE
    }
    //constructor
    public GameData(int gameId)
    {
        this.gameId = gameId;
        this.p1RunningPoints = 0;
        this.p2RunningPoints = 0;
        this.rounds = new ArrayList<>();
        this.currentLead = null;
    }
    //takes points input by user and creates a round object.  Also updates who is in the current lead
    public void tallyRound(int p1Points, int p2Points)
    {
        this.rounds.add(new Round(rounds.size()+1, p1Points, p2Points));
        this.p1RunningPoints += p1Points;
        this.p2RunningPoints += p2Points;
        updateCurrentLead();

    }
    //this method updates the current lead so that game is constantly aware of who is winning
    private void updateCurrentLead()
    {
        if(this.p1RunningPoints > this.p2RunningPoints)
            this.currentLead = player.PLAYER_ONE;
        else if(this.p1RunningPoints < this.p2RunningPoints)
            this.currentLead = player.PLAYER_TWO;
        else
            this.currentLead = player.TIE;
    }

    /*
        Returns true if p1's total points have crossed 100
     */
    public boolean p1Crossed100()
    {
        return p1RunningPoints >= 100;
    }
    /*
    Returns true if p2's total points have crossed 100
 */
    public boolean p2Crossed100()
    {
        return p2RunningPoints >= 100;
    }
    /*
        Returns a string of the current winner, or tie if tie
     */
    public String getWinner()
    {
        return this.currentLead.toString();
    }

    public int getP1RunningPoints()
    {
        return this.p1RunningPoints;
    }
    public int getP2RunningPoints()
    {
        return this.p2RunningPoints;
    }
    public int getRound()
    {
        return this.rounds.size();
    }

    public String getRoundString()
    {
        String result = "";
        //StringBuilder sb = new StringBuilder();
        for(int i=0; i<rounds.size(); i++)
        {
            result += String.format("Round %d: %d\t\t\t\t%d\n", i+1, this.rounds.get(i).getP1Points(), this.rounds.get(i).getP2Points());
            //sb.append("ROUND# r.getP1Points() + "                              " + r.getP2Points() + "\n");
            //rounds += r.getP1Points() + "\t\t\t" + r.getP2Points() + "\n";
        }

        return result;
    }
}
