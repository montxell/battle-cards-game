package com.codethen.battlecards;

import java.util.List;
import java.util.Scanner;

public class Game {

    /** total num of players */
    public static final int NUM_TOTAL_PLAYERS = 2;

    /** maximum num of cards a player can take */
    public static final int MAX_CARDS_TO_TAKE = 5;

    /** maximum num of cards a player can reject */
    public static final int MAX_CARDS_TO_REJECT = Game.MAX_CARDS_TO_TAKE - Hand.NUM_TOTAL_CARDS;

    /** minimum num of cards to play a battle */
    public static final int MIN_CARDS_TO_PLAY_BATTLE = MAX_CARDS_TO_TAKE * NUM_TOTAL_PLAYERS;  //Cambio mínimo de cartas de 6 a 10.
                                                                                               //Cada jugador tiene opción de coger max 5 cartas de la baraja
                                                                                               //(3 para quedarse y 2 para descartar) en cada combate.
    private Deck deck;

    private Player p1;
    private Player p2;

    private Player currentPlayer;
    private Player nextPlayer;


    public Game(Deck deck, Player p1, Player p2) {
        this.deck = deck;
        this.p1 = p1;
        this.p2 = p2;
    }



    public void start(boolean p1StartsToPick) {

        // Player who starts to pick cards

        if (p1StartsToPick) {

            currentPlayer = p1;
            nextPlayer = p2;

        } else {

            currentPlayer = p2;
            nextPlayer = p1;
        }


        // Battles

        while(deck.getCount() >= MIN_CARDS_TO_PLAY_BATTLE) {

            playBattle();

        }


        // Final winner or tie of the game

        getWinner();

    }



    public void playBattle() {

        preparePlayersHands();
        comparePlayersHands();
        resetPlayersHands();
        battlesStatus();


    }



    private void preparePlayersHands() {

        Scanner scanner = new Scanner(System.in);

        while ( isOnePlayersHandNotFull() ) {

            System.out.println("It is " + currentPlayer.getName() + "'s turn.");


            if (currentPlayer.getHand().getCountCardsInHand() == Hand.NUM_TOTAL_CARDS) {

                System.out.println("Your hand is full.");


            } else if (currentPlayer.getNumCardsRejected() < Game.MAX_CARDS_TO_REJECT) {

                Card pickedCard= deck.pickCard();

                System.out.println("Your card is: " + pickedCard.toString());


                System.out.println("Do you want to keep the card?");
                System.out.print("Y/N: ");
                String cardDecision = scanner.next();


                if (cardDecision.equals("Y")) {

                    currentPlayer.getHand().addCard(pickedCard);


                } else {

                    currentPlayer.incrementNumCardsRejected();

                }


            } else {

                System.out.println("You have rejected 2 cards. You have to keep the next card.");

                Card pickedCard= deck.pickCard();

                currentPlayer.getHand().addCard(pickedCard);

                System.out.println("The card added to your hand is: " + pickedCard.toString());

            }

            swapPlayer();
        }

    }



    private void swapPlayer() {

        Player temp;
        temp = currentPlayer;
        currentPlayer = nextPlayer;
        nextPlayer = temp;

    }


    private boolean isOnePlayersHandNotFull(){

        return (currentPlayer.getHand().getCountCardsInHand() != Hand.NUM_TOTAL_CARDS) || (nextPlayer.getHand().getCountCardsInHand() != Hand.NUM_TOTAL_CARDS);

        }


    private void comparePlayersHands() {

        int p1MagicPoints = 0;
        int p1StrengthPoints = 0;
        int p1SkillPoints = 0;

        for (int i = 0; i < p1.getHand().getCountCardsInHand(); i++) {
            p1MagicPoints += p1.getHand().getCardFromHand(i).magic;
            p1StrengthPoints += p1.getHand().getCardFromHand(i).strength;
            p1SkillPoints += p1.getHand().getCardFromHand(i).skill;
        }

        System.out.println(p1.getName() + " total points:");
        System.out.println("magic " + p1MagicPoints + ", strength " + p1StrengthPoints + ", skill " + p1SkillPoints);


        int p2MagicPoints = 0;
        int p2StrengthPoints = 0;
        int p2SkillPoints = 0;

        for (int i = 0; i < p2.getHand().getCountCardsInHand(); i++) {
            p2MagicPoints += p2.getHand().getCardFromHand(i).magic;
            p2StrengthPoints += p2.getHand().getCardFromHand(i).strength;
            p2SkillPoints += p2.getHand().getCardFromHand(i).skill;
        }

        System.out.println(p2.getName() + " total points:");
        System.out.println("magic " + p2MagicPoints + ", strength " + p2StrengthPoints + ", skill " + p2SkillPoints);



        if ((p1MagicPoints > p2MagicPoints && p1StrengthPoints > p2StrengthPoints) || (p1MagicPoints > p2MagicPoints && p1SkillPoints > p2SkillPoints) || (p1StrengthPoints > p2StrengthPoints && p1SkillPoints > p2SkillPoints)) {

            p1.incrementPoints();
            System.out.println(p1.getName() + " wins the battle!");

        } else if ((p2MagicPoints > p1MagicPoints && p2StrengthPoints > p1StrengthPoints) || (p2MagicPoints > p1MagicPoints && p2SkillPoints > p1SkillPoints) || (p2StrengthPoints > p1StrengthPoints && p2SkillPoints > p1SkillPoints)) {

            p2.incrementPoints();
            System.out.println(p2.getName() + " wins the battle!");

        } else {

            System.out.println("There is a tie. No points added.");
        }

    }



    private void resetPlayersHands() {

        p1.getHand().removeAllCards();
        p1.setNumCardsRejected(0);
        p2.getHand().removeAllCards();
        p2.setNumCardsRejected(0);

    }



    private void battlesStatus() {

        System.out.println("Battles status:");
        System.out.println(p1.getName() + " " + p1.getPoints() + " - " + p2.getName() + " " + p2.getPoints());

    }



    private void getWinner(){

        if (p1.getPoints() > p2.getPoints()) {

            System.out.println("The winner of the game is: " + p1.getName());

        } else if (p2.getPoints() > p1.getPoints()) {

            System.out.println("The winner of the game is: " + p2.getName());

        } else {

            System.out.println("Tie game!");
        }
    }

}
