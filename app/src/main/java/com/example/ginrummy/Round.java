package com.example.ginrummy;

import java.io.Serializable;

/**
 * This class holds all the data for an individual round of Gin Rummy including the current round count
 * p1's round points p2's round points and the winner of the round
 */
public class Round implements Serializable {
    private int roundId;
    private int p1Points;
    private int p2Points;
    private player winner;

    //enumerate players
    private enum player {
        PLAYER_ONE,
        PLAYER_TWO,
        TIE
    }

    //constructor
    public Round(int roundId, int p1Points, int p2Points) {
        this.roundId = roundId;
        this.p1Points = p1Points;
        this.p2Points = p2Points;
        updateCurrentLead();

    }

    /*
        updates who is the winner of current round
     */
    private void updateCurrentLead() {
        if (this.p1Points > this.p2Points)
            this.winner = player.PLAYER_ONE;
        else if (this.p1Points < this.p2Points)
            this.winner = player.PLAYER_TWO;
        else
            this.winner = player.TIE;
    }

    public int getP1Points() {
        return this.p1Points;
    }

    public int getP2Points()
    {return this.p2Points;}
}
