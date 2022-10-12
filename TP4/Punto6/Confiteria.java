package TP4.Punto6;

import java.util.concurrent.Semaphore;

public class Confiteria {
    private Semaphore semEmpleado;
    private Semaphore semComida;
    private Semaphore semAsiento;

    public Confiteria(){
        this.semEmpleado = new Semaphore(0);
        this.semComida = new Semaphore(0);
        this.semAsiento = new Semaphore(1);
    }

    //Metodos utilizados por el empleado
    public void sentarse() throws InterruptedException{
        semAsiento.acquire();
    }
    public void llamarMozo() throws InterruptedException{
        semEmpleado.release();
    }
    public void tomarComida() throws InterruptedException{
        semComida.acquire();
    }
    public void dejarAsiento() throws InterruptedException{
        semAsiento.release();
    }

    //Metodos utilizados por el Mozo
    public void tomarPedido() throws InterruptedException{
        semEmpleado.acquire();
    }
    public void servirComida() throws InterruptedException{
        semComida.release();
    }
}
