package com.codethen.battlecards;


public class Player {

    private String name;

    private Hand hand;

    private int points;

    private int numCardsRejected;


    public Player(String name) {

        this.name = name;

        this.hand = new Hand();

        this.points = 0;

        this.numCardsRejected = 0;

    }


    public String getName() {

        return name;
    }


    public Hand getHand() {

        return this.hand;
    }


    public int getPoints() {

        return this.points;
    }


    public void incrementPoints() {

        this.points++;
    }


    public int getNumCardsRejected() {

        return this.numCardsRejected;
    }

    public void setNumCardsRejected(int numCardsRejected) {

        this.numCardsRejected = numCardsRejected;

    }

    public void incrementNumCardsRejected() {

        this.numCardsRejected++;
    }


}
