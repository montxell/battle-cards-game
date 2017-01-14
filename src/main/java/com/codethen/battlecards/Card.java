package com.codethen.battlecards;


public class Card {

    // Las propiedades las hacemos publicas para no hacer luego un 'get', y para que no se puedan modificar, es decir, una
    // vez creados sean así siempre, ponemos que sean constantes con 'final'.

    public final int magic;
    public final int strength;
    public final int skill;


    // constructor

    public Card(int magic, int strength, int skill) {
        this.magic = magic;
        this.strength = strength;
        this.skill = skill;


        // Lanzamos una excepción

        if (magic < 1 || strength < 1 || skill < 1 || magic + strength + skill != 10) {

            throw new IllegalArgumentException("wrong values " + toString());
        }

    }



    @Override
    public String toString() {

        return "magic:" + magic + ", strength:" + strength + ", skill:" + skill;

    }

}
