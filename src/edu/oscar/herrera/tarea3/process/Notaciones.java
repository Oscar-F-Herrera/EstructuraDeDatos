package edu.oscar.herrera.tarea3.process;

import edu.oscar.herrera.utils.Stack;

import java.util.Optional;

/**
 * Esta clase se encarga de los procesos para convertir una operacion de notacion infija a postfija
 */
public class Notaciones {
    /**
     * Este método convierte una notación infija a una postfija
     * @param notacion la notacion infija que recibe del CLI
     * @return la notacion postfija de la operacion
     */
    public static String convertirNotacion(String notacion) {
        byte prioridadPredecesor = 0;
        String notacionPostfija = "";
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < notacion.length(); i++) {

            char elemento = notacion.charAt(i);

            if (elemento == ' ') {
                continue;
            }

            boolean esOperador = verificarOperador(elemento);

            if (esOperador) {

                byte prioridadOperador = obtenerPrioridadOperador(elemento);

                if (prioridadOperador == prioridadPredecesor && !pila.isEmpty()) {
                    notacionPostfija = notacionPostfija + pila.pop().get();
                    pila.push(elemento);
                } else if (prioridadOperador > prioridadPredecesor) {
                    pila.push(elemento);
                } else {
                    while (pila.size() > 0) {
                        notacionPostfija = notacionPostfija + pila.pop().get();
                    }
                    pila.push(elemento);
                }

                prioridadPredecesor = prioridadOperador;

            } else {
                notacionPostfija = notacionPostfija + elemento;
            }
        }

        while (pila.size() > 0) {
            notacionPostfija = notacionPostfija + pila.pop().get();
        }

        return notacionPostfija;
    }

    /**
     * Este método se encarga de resolver la operacion postfija
     * @param notacion la notacion postfija proveniente del CLI
     * @return el resultado de la operacion
     */
    public static String obtenerResultado(String notacion) {

        Stack<Float> pila = new Stack<>();

        float operando1;
        float operando2;

        for (int i = 0; i < notacion.length(); i++) {
            char elemento = notacion.charAt(i);

            boolean esOperador = verificarOperador(elemento);

            if (!esOperador) {
                float numero = Float.parseFloat(String.valueOf(elemento));
                pila.push(numero);
            } else {
                operando2 = pila.pop().get();
                operando1 = pila.pop().get();

                float resultado = realizarOperacion(operando1,operando2,elemento);
                pila.push(resultado);
            }
        }
        return pila.pop().get().toString();
    }

    /**
     * Este método verifica si el elemento enviado es un operador
     * @param elemento el elemento a verificar
     * @return true si es un operador, false si no lo es
     */
    public static boolean verificarOperador(char elemento) {
        return elemento == '^' || elemento == '*' || elemento == '/' || elemento == '+' || elemento == '-';
    }

    /**
     * Este método asigna un nivel de prioridad dependiendo del operador del elemento enviado
     * @param elemento el elemento a revisar
     * @return el nivel de prioridad
     */
    public static byte obtenerPrioridadOperador(char elemento) {
        if (elemento == '+' || elemento == '-') {
            return 0;
        } else if (elemento == '*' || elemento == '/') {
            return 1;
        } else {
            return 2;
        }
    }

    /**
     * Este método realiza una operación dependiendo del operador
     * @param op1 el primer número
     * @param op2 el segundo número
     * @param operador el parámetro que decide que operación se le realizara al primer número
     * @return el resultado de la operación
     */
    public static float realizarOperacion(float op1, float op2, char operador) {
        switch (operador) {
            case '^' -> {
                return (float) Math.pow(op1, op2);
            }
            case '/' -> {
                return (op1 / op2);
            }
            case '*' -> {
                return (op1 * op2);
            }
            case '-' -> {
                return (op1 - op2);
            }
            case '+' -> {
                return (op1 + op2);
            }
        }
        return 0;
    }
}
