package edu.oscar.herrera.tarea2.autobuses.process;

import edu.oscar.herrera.tarea2.autobuses.ui.CLI;
import edu.oscar.herrera.utils.ListaEnlazada;

import java.util.Scanner;

/**
 * Esta clase trabaja con la lista del autobus agregando o eliminando pasajeros
 */
public class AutobusPrograma {
    public static ListaEnlazada<String> ListaBus = new ListaEnlazada<>();

    /**
     * Este método agrega 3 pasajeros a la lista del autobus y ejecuta el método operacionLista
     */
    public static void busSetup(){
        ListaBus.add("Pedro");
        ListaBus.add("Maria");
        ListaBus.add("Carlos");
        AutobusPrograma.operacionLista();
    }

    /**
     * Este método obtiene un dato en base al método accionUsuario y realiza una accion dependiendo de ese dato
     */
    public static void operacionLista() {

        String accionarealizar;
        accionarealizar = CLI.accionUsuario();

        switch (accionarealizar) {
            case "agregar":
                System.out.println("Por favor escriba el nombre del nuevo pasajero");
                Scanner leerinput = new Scanner(System.in);
                String pasajeronuevo = leerinput.nextLine();
                ListaBus.add(pasajeronuevo);
                operacionLista();
                break;
            case "borrar":
                System.out.println("Por favor seleccione el pasajero a eliminar");
                System.out.println("(Por numero en orden)");
                leerinput = new Scanner(System.in);
                String pasajeroborrar = leerinput.nextLine();
                ListaBus.remove(pasajeroborrar);
                operacionLista();
                break;
            case "ver":
                System.out.println(ListaBus.toString());
                operacionLista();
                break;

        }
    }
}
