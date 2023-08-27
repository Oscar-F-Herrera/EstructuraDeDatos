package tarea2.futbol.ui;

import tarea2.futbol.clases.Player;
import tarea2.utils.ListaEnlazada;
import tarea2.utils.Node;

import java.util.Optional;
import java.util.Scanner;

import static tarea2.futbol.process.PartidoFutbol.createPlayer;

/**
 * Mediante esta clase el usuario ingresa los datos para llenar los equipos
 */
public class CLI {
    static ListaEnlazada<Player> playersToChoose = new ListaEnlazada<>();
    static ListaEnlazada<Player> team1 = new ListaEnlazada<>();
    static ListaEnlazada<Player> team2 = new ListaEnlazada<>();

    static Scanner scanner = new Scanner(System.in);

    static String name;
    static int number;

    /**
     * Este método pregunta por los datos de los jugadores
     */
    public static void Partido() {
        System.out.println("Capitán 1, ingresa tu nombre:");
        name = scanner.nextLine();
        System.out.println("ingresa tu número de camiseta: ");
        number = scanner.nextInt(); scanner.nextLine();
        Player cap1 = createPlayer(name,number,true);
        team1.add(cap1);
        System.out.println();

        System.out.println("Capitán 2, ingresa tu nombre:");
        name = scanner.nextLine();
        System.out.println("ingresa tu número de camiseta: ");
        number = scanner.nextInt(); scanner.nextLine();
        Player cap2 = createPlayer(name,number,true);
        team2.add(cap2);
        System.out.println();

        for (int i = 0; i < 8; i++) {
            System.out.println("Ingresa el nombre del jugador " + (i+1) + ":");
            name = scanner.nextLine();
            System.out.println("Ingresa el número del jugador " + (i+1) + ":");
            number = scanner.nextInt(); scanner.nextLine();
            Player player = createPlayer(name,number,false);
            playersToChoose.add(player);
            System.out.println();
        }

        boolean isFound = false;

        while (playersToChoose.size() != 0){
            isFound = false;

            while (!isFound){
                System.out.println("Capitán " + cap1.getName() + " , selecciona a un jugador:");
                playersToChoose.showList();
                name = scanner.nextLine();

                Optional<Node<Player>> currentNode = playersToChoose.getFirstNode();
                while (!currentNode.isEmpty()){
                    if (currentNode.get().getData().getName().equals(name)){
                        team1.add(currentNode.get().getData());
                        playersToChoose.remove(currentNode.get().getData());
                        isFound = true;
                        System.out.println("Jugador agregado \n");
                        break;
                    }
                    currentNode = currentNode.get().getNext();
                }
                if (!isFound){
                    System.out.println("El jugador no fue encontrado o ya fue seleccionado, por favor, intente de nuevo");
                }
            }

            isFound = false;

            while (!isFound){
                System.out.println("Capitán " + cap2.getName() + " , selecciona a un jugador:");
                playersToChoose.showList();
                name = scanner.nextLine();

                Optional<Node<Player>> currentNode = playersToChoose.getFirstNode();
                while (!currentNode.isEmpty()){
                    if (currentNode.get().getData().getName().equals(name)){
                        team2.add(currentNode.get().getData());
                        playersToChoose.remove(currentNode.get().getData());
                        isFound = true;
                        System.out.println("Jugador agregado \n");
                        break;
                    }
                    currentNode = currentNode.get().getNext();
                }
                if (!isFound){
                    System.out.println("El jugador no fue encontrado o ya fue seleccionado, por favor, intente de nuevo");
                }
            }
        }
        showResults();
    }

    /**
     * Este método muestra los equipos completos y los jugadores que faltan si es que hay
     */
    public static void showResults(){
        System.out.println("Equipo 1:");
        team1.showList();
        System.out.println();

        System.out.println("Equipo 2:");
        team2.showList();
        System.out.println();

        System.out.println("Jugadores restantes:");
        playersToChoose.showList();
    }
}
