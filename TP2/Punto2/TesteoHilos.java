package TP2.Punto2;

public class TesteoHilos {
    public static void main(String[] args) {
        Thread miHilo = new MiEjecucion();
        miHilo.start();
        try {
            miHilo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("En el main");
    }   
}