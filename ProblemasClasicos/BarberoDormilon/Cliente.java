package ProblemasClasicos.BarberoDormilon;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente implements Runnable{
    private String miNombre;
    private Barberia laBarberia;

    public Cliente(String n, Barberia b){
        this.miNombre = n;
        this.laBarberia = b;
    }

    private void caminarHastaBarberia(){
        System.out.println("Soy "+miNombre+" estoy caminando hacia la barberia.");
        try {
            Thread.sleep((int) Math.random()*200);
        } catch (InterruptedException e) {
            Logger.getLogger(Barbero.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Interrumpieron mi trabajo");   
        }
    }

    public void run(){
        this.caminarHastaBarberia();
        if(laBarberia.entrar(miNombre)){
            laBarberia.solicitarCorte(miNombre);
            System.out.println("------Soy "+miNombre+" ya me atendieron, ME VOY.");
            laBarberia.salir(miNombre);
        }else{
            System.out.println("------Soy "+miNombre+" el barbero esta ocupado, ME VOY.");
        }
    }
}
