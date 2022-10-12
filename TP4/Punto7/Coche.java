package TP4.Punto7;

import java.util.Random;

public class Coche extends Thread {
    private GestorCruce gestor;
    private String nombre;

    public Coche(GestorCruce ges, String nom) {
        this.gestor = ges;
        this.nombre = nom;
    }

    public void run() {
        Random random = new Random();
        int n = random.nextInt(2);
        switch (n) {
            case 0:
                llegaNorte();
                break;
            case 1:
                llegaOeste();
                break;
            default:
                break;
        }
    }

    public void llegaNorte() {
                try {
                    this.gestor.cruzaNorte();
                    System.out.println("+++"+this.nombre + " cruzando por semaforo Norte.");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("---"+this.nombre + " termino de cruzar por semaforo Norte.");
                this.gestor.saleNorte();
            
        

    }

    public void llegaOeste() {
            try {
                this.gestor.cruzaOeste();
                System.out.println("---"+this.nombre + " cruzando por semaforo Oeste.");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("---"+this.nombre + " termino de cruzar por semaforo Oeste.");
            this.gestor.saleOeste();
    }
}
