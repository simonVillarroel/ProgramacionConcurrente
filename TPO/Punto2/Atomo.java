package TPO.Punto2;

import java.util.Random;

public class Atomo implements Runnable{
    private Espacio espacio;
    private String tipo;

    public Atomo(Espacio e,String t){
        this.espacio = e;
        this.tipo = t;
    }
    
    public void run(){
        Random random = new Random();
        try {
            System.out.println(Thread.currentThread().getName()+" de "+ this.tipo+": Liberado en el espacio.");
            Thread.sleep((random.nextInt(9))*1000);
            if(this.tipo == "Oxigeno"){
                this.espacio.liberarOxigeno();
            }else{
                this.espacio.liberarHidrogeno();
            }
            this.espacio.usarAtomo(tipo);
            System.out.println(Thread.currentThread().getName()+" de "+ this.tipo+": Usado.");
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    
}
