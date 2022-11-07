package TP6.Punto2;

import java.util.Random;

public class ControlTemperatura extends Thread{
    private GestorSala gestor;
    private int temperaturaActual;

    public ControlTemperatura(GestorSala g){
        this.gestor = g;
        this.temperaturaActual = 0;
    }

    public void run(){
        Random random = new Random();
        while(true){
            System.out.println("Control Temperatura: Nueva medicion de la temperatura");
            temperaturaActual = random.nextInt(21)+20;
            this.gestor.notificarTemperatura(temperaturaActual);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
