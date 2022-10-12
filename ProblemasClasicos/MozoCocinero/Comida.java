package ProblemasClasicos.MozoCocinero;

import java.util.concurrent.Semaphore;

public class Comida {
    private Semaphore sem_pedido;
    private Semaphore sem_comidaLista;
    private String pedido;

    public Comida(){
        this.sem_pedido = new Semaphore(0);
        this.sem_comidaLista = new Semaphore(0);
        this.pedido = "";
    }

    //Metodos usados por Mozo
    public void pedirComida(){
        setPedido("pedido de "+Thread.currentThread().getName()+".");
        sem_pedido.release();
    }

    public void esperarComida(){
        try {
            sem_comidaLista.acquire();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //Metodos usados por Cocinero
    public String esperarPedido(){
        try {
            sem_pedido.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.pedido;
    }

    public void entregarPedido(){
        sem_comidaLista.release();
    }


    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }
}
