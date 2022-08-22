package TP2.Punto5;

public class MiHilo implements Runnable{
    String nombreHilo;

    public void unHilo(String nombre){
        nombreHilo = nombre;
    }
    //Punto de entrada del hilo
    //Los hilos comienzan a ejecutarse aqui
    public void run(){
        System.out.println("Comenzando "+nombreHilo);
        try {
            for (int contar=0; contar<10; contar++){
                Thread.sleep(400);
                System.out.println("En "+nombreHilo+", el recuento "+contar);
            }
        }catch (InterruptedException exc){
            System.out.println(nombreHilo + "Interrumpido.");
        }
        System.out.println("Terminando "+nombreHilo);

        //Porcion de codigo para quitar el sleep
        /*for (int contar=0; contar<10; contar++){
            System.out.println("En "+nombreHilo+", el recuento "+contar);
        }*/
    }
}
