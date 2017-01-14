package com.codethen.battlecards;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    private List<Card> cards;


    public Deck() {

        this.cards = generateCards();  //También puede ser:   this.cards = new ArrayList<>();
                                       //                     generateCards();

        this.cards = shuffle();        // Desordenar la baraja, generar números aleatorios, de donde a donde, qué limites se necesitan
                                       // y cómo mover un objeto de un objeto a otro, como las arrays, intercambiar.

    }




    public int getCount(){

        return cards.size();

    }


    private List<Card> generateCards() {

        List<Card> cards = new ArrayList<>();


        // Generar las cartas

        for (int magic = 1; magic <= 8; magic++) {
            for(int strength = 1; strength <= 9 - magic; strength ++) {
                final int skill = 10 - magic - strength;
                final Card card = new Card(magic, strength, skill);
                cards.add(card);

                // cards.add(new Card(magic, strength, skill);

            }

        }

        return cards;

    }


    public List<Card> shuffle() {

        Random random = new Random();

        List<Card> temp = new ArrayList<>();

        while (cards.size() > 0) {

            int cardPosition = random.nextInt(cards.size());

            temp.add(cards.get(cardPosition));
            cards.remove(cardPosition);
        }

        cards = temp;

        return cards;
    }


    public Card getCardFromDeck() {

        return cards.get(0);
    }


    public Card removePickedCard() {

        return cards.remove(0);
    }




}
