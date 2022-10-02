package TP3.HamstersConSemaforo;

public class Main {
    public static void main(String[] args) {
        Jaula jaula = new Jaula();
        int cantidadHilos = 5;
        Thread[] arregloHilos=new Thread[cantidadHilos];

        for (int d=0; d<cantidadHilos; d++) {	
			Hamster hiloRun= new Hamster(jaula);
			Thread hilo= new Thread(hiloRun,"Hamster "+(d+1));
			hilo.start();
			arregloHilos[d]=hilo;
		}
    }
}
