package com.codethen.battlecards;


import org.junit.Test;

public class CardTest {

    @Test
    public void createValidCards() {  // En este caso no es necesario poner Card card = new Car( , , )
        new Card(1,1,8);
        new Card(3,3,4);
        new Card(2,6,2);
        new Card(8,1,1);
    }


    @Test(expected = IllegalArgumentException.class) // Se le pasa la clase del objeto, y por eso se pone .class
    public void createInvalidCard1() {  // Este método lo tiene que ejecutar junit (está en pom.xml (battlecards) en dependencies)

        Card card = new Card(1,1,2);
    }

    @Test(expected = IllegalArgumentException.class) // Se le pasa la clase del objeto, y por eso se pone .class
    public void createInvalidCard2() {  // Este método lo tiene que ejecutar junit (está en pom.xml (battlecards) en dependencies)

        Card card = new Card(6,7,4);
    }
}
