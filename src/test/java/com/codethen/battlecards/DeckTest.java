package com.codethen.battlecards;


import org.junit.Assert;
import org.junit.Test;

public class DeckTest {

    @Test
    public void createDeck() {

        Deck deck = new Deck();

        Assert.assertEquals(36, deck.getCount());  // lo que espero,  y lo que tengo


    }
}
