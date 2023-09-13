package edu.oscar.herrera.tarea2.futbol.process;


import edu.oscar.herrera.tarea2.futbol.clases.Player;

/**
 * Esta clase tiene el proceso para crear un jugador
 */
public class PartidoFutbol {
    public static Player createPlayer(String name, int number, boolean isCaptain){
        return new Player(name,number,isCaptain);
    }
}
