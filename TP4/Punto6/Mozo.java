package TP4.Punto6;

public class Mozo implements Runnable{
    private Confiteria confiteria;

    public Mozo(Confiteria confi){
        this.confiteria = confi;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+": Comienza el turno.");
       
        while(true){
            try {
                System.out.println(Thread.currentThread().getName()+
                ": Inventa nuevas versiones de pollo, espera a que algun empleado lo llame.");
                confiteria.tomarPedido();
                System.out.println(Thread.currentThread().getName()+": Toma el pedido.");
                esperarCocinero();
                System.out.println(Thread.currentThread().getName()+": Comida lista, sirviendo al empleado.");
                confiteria.servirComida();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void esperarCocinero(){
        int random = (int) (Math.random() * 3 + 3);
        try{
            Thread.sleep(random*1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

