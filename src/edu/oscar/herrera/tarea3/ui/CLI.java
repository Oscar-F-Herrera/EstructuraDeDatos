package edu.oscar.herrera.tarea3.ui;

import java.util.Scanner;

import static edu.oscar.herrera.tarea3.process.Notaciones.convertirNotacion;
import static edu.oscar.herrera.tarea3.process.Notaciones.obtenerResultado;

/**
 * En esta clase se encuentra el método que muestra mensajes a la pantalla
 */
public class CLI {
    /**
     * Este método pregunta por una notación infija e imprime los resultados
     */
    public static void preguntarPorNotacion(){
        Scanner scanner = new Scanner(System.in);

        String notacion;

        System.out.println("Bienvenido, ingrese una notación infija:");
        notacion = scanner.nextLine();
        notacion = convertirNotacion(notacion);
        System.out.println();

        System.out.println("Esta operación en notación postfija se escribe como:");
        System.out.println(notacion);
        System.out.println();

        System.out.println("El resultado de esta operación es:");
        System.out.println(obtenerResultado(notacion));
    }
}
