package TPO.Punto3;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int cantidadDeDurmientes = 10;
        Thread[] durmientes = new Thread[cantidadDeDurmientes];
        Reloj reloj = new Reloj(cantidadDeDurmientes);
        ControlReloj control = new ControlReloj(reloj);
        Thread hiloControl = new Thread(control, "Control del reloj");

        //Creacion de los hilos Durmiente
        Random random = new Random();
        for(int i=0; i < cantidadDeDurmientes; i++){
            Durmiente durmiente = new Durmiente(reloj, random.nextInt(24),5);
            Thread hiloDurmiente = new Thread(durmiente, "Durmiente"+(i+1));
            durmientes[i] = hiloDurmiente;
            hiloDurmiente.start();
        }
        hiloControl.start();
    }
}
