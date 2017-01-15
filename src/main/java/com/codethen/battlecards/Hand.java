package com.codethen.battlecards;

import java.util.ArrayList;
import java.util.List;


public class Hand {

    /** num cards when hand is full */
    public static final int NUM_TOTAL_CARDS = 3;

    private List<Card> cardsInHand;

    private Player p1;
    private Player p2;


    public Hand() {

        this.cardsInHand = new ArrayList<>();

    }



    public void addCard (Card card) {

        this.cardsInHand.add(card);

    }


    public int getCountCardsInHand() {

        return this.cardsInHand.size();
    }


    public Card getCardFromHand(int index) {

        return this.cardsInHand.get(index);
    }



    public void removeAllCards () {

        this.cardsInHand.clear();

    }

}
