package tarea2.autobuses.ui;

import java.util.Scanner;

/**
 * Mediante esta clase el usuario elige que accion realizar
 */
public class CLI {
    /**
     * Pregunta al usuario que accion quiere realizar
     * @return la accion elegida por el usuario
     */
    public static String accionUsuario (){

        System.out.println("Por favor escoga la accion que quiere realizar");
        System.out.println("a) Borrar un Pasajero");
        System.out.println("b) Agregar un Pasajero");
        System.out.println("c) Visualisar datos de Bus");
        System.out.println("d) Cerrar Programa");

        Scanner leeropcion = new Scanner(System.in);
        String seleccionmenu = leeropcion.nextLine();
        String returnvalor = "";

        switch (seleccionmenu) {
            case "a":
                returnvalor ="borrar";

                break;
            case "b":
                returnvalor ="agregar";
                break;
            case "c":
                returnvalor ="ver";
                break;
            case "d":
                System.exit(0);
                break;
            default:
                System.out.println("Favor de introducir una opcion valida");
                accionUsuario();
        }

        return returnvalor;
    }
}
