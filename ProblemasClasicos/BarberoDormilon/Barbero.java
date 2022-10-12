package ProblemasClasicos.BarberoDormilon;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Barbero implements Runnable{
    private Barberia miBarberia;
    private String miNombre;

    public Barbero(String n, Barberia b){
        this.miNombre = n;
        this.miBarberia = b;
    }

    private void atender(){
        System.out.println("Estoy atendiendo");
        try {
            Thread.sleep((int) Math.random()*200);
        } catch (InterruptedException e) {
            Logger.getLogger(Barbero.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Interrumpieron mi trabajo");   
        }
    }

    public void run(){
        int cuantos = 0;
        System.out.println("Soy el barbero "+miNombre);

        while(true){
            miBarberia.esperarCliente(miNombre);
            this.atender();
            miBarberia.terminarAtencion();
            cuantos++;
            System.out.println("Cuantos atendi "+ cuantos+ " ************");
        }
    }
}
