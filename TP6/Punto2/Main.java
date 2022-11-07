package TP6.Punto2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Thread[] personas = new Thread[100];
        GestorSala gestor = new GestorSala();
        ControlTemperatura control = new ControlTemperatura(gestor);
        control.start();

        //Creacion de los hilos Persona
        for(int i =0; i < personas.length; i++){
            boolean jubilado = random.nextBoolean();
            Persona persona = new Persona(gestor, jubilado);
            Thread hiloPersona = new Thread(persona, "Persona"+i);
            personas[i] = hiloPersona;
            hiloPersona.start();
        }
    }
}
