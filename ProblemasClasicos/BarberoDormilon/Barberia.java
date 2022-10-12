package ProblemasClasicos.BarberoDormilon;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Barberia {
    private Semaphore semSillon;
    private Semaphore semBarbero;
    private Semaphore semCliente;

    public Barberia(String n){
        this.semSillon = new Semaphore(1);
        this.semBarbero = new Semaphore(0);
        this.semCliente = new Semaphore(0);
        System.out.println("Bienvenidos a la barberia "+n+".");
    }

    public boolean entrar(String nombreCliente){
        System.out.println("------Soy "+nombreCliente+" estoy en la barberia");
        return (semSillon.tryAcquire());
    }
    public void solicitarCorte(String nombreCliente){
        System.out.println("------Soy "+nombreCliente+" solicite un corte");
        semBarbero.release();
        try {
            semCliente.acquire();
        } catch (InterruptedException e) {
            Logger.getLogger(Barberia.class.getName()).log(Level.SEVERE, null, e);   
        }

    }
    public void salir(String nombre){
        semSillon.release();
    }

    public void esperarCliente(String nombreBarbero){
        try {
            semBarbero.acquire();
        } catch (InterruptedException e) {
            Logger.getLogger(Barberia.class.getName()).log(Level.SEVERE, null, e);   
        }
    }

    public void terminarAtencion(){
        semCliente.release();
    }

}
