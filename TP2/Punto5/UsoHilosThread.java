package TP2.Punto5;

public class UsoHilosThread {
    public static void main(String[] args) {
        System.out.println("Hilo principal iniciando.");
    //Construye 3 objetos MiHiloThread.
        MiHiloThread hilo1 = new MiHiloThread("#1");
        MiHiloThread hilo2 = new MiHiloThread("#2");
        MiHiloThread hilo3 = new MiHiloThread("#3");
    //Luego comienza la ejecución del hilo.
        hilo1.start();
        hilo2.start();
        hilo3.start();
        
        for (int i=0; i<50;i++){
            System.out.print(" .");
        }
        try{
            Thread.sleep(100);
        }catch (InterruptedException exc){
            System.out.println("Hilo principal interrumpido.");
        }
        System.out.println("Hilo principal finalizado.");
    }
}
