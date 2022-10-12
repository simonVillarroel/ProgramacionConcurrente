package TP5.Punto1;

public class Cocinero implements Runnable{
    private Confiteria confiteria;

    public Cocinero(Confiteria confi){
        this.confiteria = confi;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+": Comienza el turno.");
       
        while(true){
            try {
                System.out.println("/// "+Thread.currentThread().getName()+
                ": Creando nuevas recetas y ordenando la cocina, espera a que algun empleado lo llame.");
                confiteria.tomarPedidoComida();
                System.out.println("/// "+Thread.currentThread().getName()+": Toma el pedido.");
                cocinar();
                System.out.println("/// "+Thread.currentThread().getName()+": Comida lista, sirviendo al empleado.");
                confiteria.servirComida();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void cocinar(){
        int random = (int) (Math.random() * 3 + 3);
        try{
            Thread.sleep(random*1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
