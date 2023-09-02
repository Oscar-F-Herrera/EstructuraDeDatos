package edu.oscar.herrera.tarea2.futbol.clases;

public class Player {
    //Atributos
    private String name;
    private int number;
    private boolean captain;
    //Métodos


    public Player() {
    }

    public Player(String nombre, int numero, boolean capitan) {
        this.name = nombre;
        this.number = numero;
        this.captain = capitan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isCaptain() {
        return captain;
    }

    public void setCaptain(boolean captain) {
        this.captain = captain;
    }

    public String toString(){
        String datos = ("Nombre: " + this.name + " | Número de camiseta: " + this.number);
        if (captain){
            return datos + " | Es capitán";
        } else {
            return datos;
        }
    }
}
