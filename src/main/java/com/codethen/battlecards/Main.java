package com.codethen.battlecards;


import java.util.Random;

/**
 *  * Se juega con una baraja especial.
 *
 * Cada carta:
 * - Tiene 3 números (habilidades): magic, strength, skill
 * - La suma de los 3 números siempre es 10.
 * - Como mínimo cada número es 1. // (es decir, el máximo posible en una habilidad según combinación sería 8)
 * - P.ej. magic 3, strength 2, skill 5
 * - Se extrae que no pueden haber cartas como 1,4,2 (no suman 10)  o 0,5,5 (un número es menor que 1)
 * - Se extrae que ninguna habilidad es mayor que 8 (las demás sumarían como mínimo 2 y el total pasaría de 10).
 * - En la baraja hay todas las combinaciones de cartas posibles (sin repetir): 1,1,8  1,2,7  1,3,6  ...etc
 * - Si vemos que son pocas cartas (salen 36) se puede decidir jugar con dos barajas (dos cartas de cada).
 *
 * Juegan dos jugadores por turnos, cada jugador alternativamente saca una carta (al azar).
 * Cada vez que sacas una carta, puedes decidir si te la quedas o la descartas.
 * Como máximo puedes sacar 5 cartas // (es decir, como máximo puedes descartar 2 cartas).
 * Cuando cada jugador ha escogido 3 cartas, se produce el combate.
 * Se extrae que un jugador como máximo puede descartar 2 cartas, ya que máximo puede sacar 5 y ha de escoger 3.
 *
 * En el combate, sumas todos los valores de cada habilidad.
 * Gana el jugador que vence en 2 habilidades (p.ej. en magic y skill).
 * Podría haber empate, si nadie gana en 2 habilidades.
 *
 * Una vez hecho un combate, se le da un punto al ganador y se vuelve a repetir el proceso hasta que no queden cartas en la baraja
 * (nota: las cartas usadas o descartadas no se vuelven a usar).
 *
 * Finalmente, cuando se acaban las cartas, el jugador que más combates gane, gana la partida.
 * Nota: se puede decidir que se acabe el juego si quedan menos de 6 cartas, ya que no se podría realizar un combate en
 * condiciones (ya que cada jugador necesita 3 cartas).
 */


public class Main {

    public static void main(String[] args) {

        // -preparar las cartas
        // 1- generar las cartas
        // 2- crear la baraja

        // - crear los jugadores

        // -el juego
        // 3- ir haciendo combates HASTA que no haya más cartas en la baraja // (Hasta hace referencia a bucle)

        // -el combate
        // 4- Los jugadores van sacando cartas HASTA que los dos hayan seleccionado 3 cartas  //(Hasta hace referencia a bucle)
        // 5- una vez han escogido 3 cartas se mira el resultado
        // 6- sumar y comparar valores, y ver quién gana -> se le da un punto al ganador


        // conceptos/clases detectadas:
        // Game (por ejemplo para guardar los puntos, o por dónde va el juego)
        // Battle (puede ser una clase o considerarlo como método dentro del Game).
        // Card, Deck, Player


        Deck deck = new Deck();

        Player p1 = new Player("Player1");
        Player p2 = new Player("Player2");

        Game game = new Game(deck, p1, p2); // Al juego le voy a pasar la baraja (Deck) y los jugadores.



        // de forma aleatoria decidimos quien escoge carta primero

        Random random = new Random();
        int result = random.nextInt(2);

        boolean p1StartsToPick = (result == 0);

        game.start(p1StartsToPick);


    }

}
