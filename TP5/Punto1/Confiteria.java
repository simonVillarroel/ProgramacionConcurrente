package TP5.Punto1;

import java.util.concurrent.Semaphore;

public class Confiteria {
    private Semaphore semPedidoBebida;
    private Semaphore semPedidoComida;
    private Semaphore semBebida;
    private Semaphore semComida;
    private Semaphore semAsiento;

    public Confiteria(){
        this.semPedidoBebida = new Semaphore(0);
        this.semPedidoComida = new Semaphore(0);
        this.semBebida = new Semaphore(0);
        this.semComida = new Semaphore(0);
        this.semAsiento = new Semaphore(2);
    }

    //Metodos utilizados por el empleado
    public void sentarse() throws InterruptedException{
        semAsiento.acquire();
    }
    public void llamarMozo() throws InterruptedException{
        semPedidoBebida.release();
    }
    public void llamarCocinero() throws InterruptedException{
        semPedidoComida.release();
    }
    public void tomarBebida() throws InterruptedException{
        semBebida.acquire();
    }
    public void tomarComida() throws InterruptedException{
        semComida.acquire();
    }
    public void dejarAsiento() throws InterruptedException{
        semAsiento.release();
    }

    //Metodos utilizados por el Mozo
    public void tomarPedidoBebida() throws InterruptedException{
        semPedidoBebida.acquire();
    }
    public void servirBebida() throws InterruptedException{
        semBebida.release();
    }

    //Metodos utilizados por el Cocinero
    public void tomarPedidoComida() throws InterruptedException{
        semPedidoComida.acquire();
    }
    public void servirComida() throws InterruptedException{
        semComida.release();
    }
}
