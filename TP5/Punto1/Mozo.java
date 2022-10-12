package TP5.Punto1;

public class Mozo implements Runnable{
    private Confiteria confiteria;

    public Mozo(Confiteria confi){
        this.confiteria = confi;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+": Comienza el turno.");
       
        while(true){
            try {
                System.out.println("+++ "+Thread.currentThread().getName()+
                ": Probando nuevas versiones de pollo, espera a que algun empleado lo llame.");
                confiteria.tomarPedidoBebida();
                System.out.println("+++ "+Thread.currentThread().getName()+": Toma el pedido.");
                buscarBebida();
                System.out.println("+++ "+Thread.currentThread().getName()+": Bebida lista, sirviendo al empleado.");
                confiteria.servirBebida();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void buscarBebida(){
        int random = (int) (Math.random() * 3 + 3);
        try{
            Thread.sleep(random*1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

