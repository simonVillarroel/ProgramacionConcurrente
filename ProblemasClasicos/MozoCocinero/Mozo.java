package ProblemasClasicos.MozoCocinero;

public class Mozo extends Thread{
    private Comida comida;

    public Mozo(Comida com, String nom){
        super(nom);
        this.comida = com;
    }

    public void generarPedido(){
        try {
            System.out.println("+++ Mozo "+Thread.currentThread().getName()+", generando el pedido.");
            Thread.sleep(5000);
            System.out.println("+++ Mozo "+Thread.currentThread().getName()+", genero el pedido.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        while(true){
            generarPedido();
            System.out.println("+++ Mozo "+Thread.currentThread().getName()+", pide la comida al cocinero.");
            this.comida.pedirComida();
            System.out.println("+++ Mozo "+Thread.currentThread().getName()+", esperando por la comida.");
            this.comida.esperarComida();
            System.out.println("+++ Mozo "+Thread.currentThread().getName()+", obtuvo la comida y la sirve.");
        }
    }
}
