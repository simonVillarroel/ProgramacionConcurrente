package ProblemasClasicos.MozoCocinero;

public class Cocinero extends Thread{
    private Comida comida;

    public Cocinero(Comida com, String nom){
        super(nom);
        this.comida = com;
    }

    public void prepararComida(){
        try {
            System.out.println("-- Cocinero "+Thread.currentThread().getName()+", preparando la comida.");
            Thread.sleep(6000);
            System.out.println("-- Cocinero "+Thread.currentThread().getName()+", termino de preparar la comida.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        String pedido;
        while(true){
            System.out.println("-- Cocinero "+Thread.currentThread().getName()+", esperando el pedido.");
            pedido = this.comida.esperarPedido();
            System.out.println("-- Cocinero "+Thread.currentThread().getName()+", obtuvo el "+pedido);
            prepararComida();
            System.out.println("-- Cocinero "+Thread.currentThread().getName()+", entrega la comida.");
            this.comida.entregarPedido();
        }
    }
}
