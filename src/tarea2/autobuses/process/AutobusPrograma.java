package tarea2.autobuses.process;

import tarea2.autobuses.ui.CLI;
import tarea2.utils.ListaEnlazada;

import java.util.Scanner;

public class AutobusPrograma {
    public static ListaEnlazada<String> ListaBus = new ListaEnlazada<>();

    public static void busSetup(){
        ListaBus.add("Pedro");
        ListaBus.add("Maria");
        ListaBus.add("Carlos");
        AutobusPrograma.operacionLista();
    }
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
