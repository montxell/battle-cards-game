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

                // También se puede realizar:  cards.add(new Card(magic, strength, skill);

            }

        }

        return cards;

    }



    public List<Card> shuffle() {

        Random random = new Random();

        for (int i = 0; i < cards.size(); i++) {

            int cardPosition = random.nextInt(cards.size());

            Card temp = cards.get(i);    // Guardamos la carta de la posición "i".

            cards.set(i, cards.get(cardPosition)); // Establecemos en la posición "i" la carta de la posición aleatoria generada (cardPosition)
            cards.set(cardPosition, temp);  // Establecemos en la posición aleatoria (cardPosition) la carta guardada inicial "temp".

        }

        return cards;

    }



    public Card pickCard () {

        Card pickedCard = cards.get(0);
        cards.remove(0);

        return pickedCard;
    }

}
