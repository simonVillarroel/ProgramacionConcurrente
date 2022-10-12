package TP4.Punto6;

public class Empleado implements Runnable{
    private Confiteria confiteria;

    public Empleado(Confiteria confi){
        this.confiteria = confi;
    }

    public void run(){
        System.out.println("    "+Thread.currentThread().getName()+" esperando un asiento");
        try {
            confiteria.sentarse();
            System.out.println("    "+Thread.currentThread().getName()+" llama al mozo.");
            confiteria.llamarMozo();
            confiteria.tomarComida();
            System.out.println("--- "+Thread.currentThread().getName()+" comiendo.");
            comer();
            System.out.println("    "+Thread.currentThread().getName()+" deja el asiento y saluda al mozo.");
            confiteria.dejarAsiento();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void comer(){
        int random = (int) (Math.random() * 3 + 3);
        try{
            Thread.sleep(random*1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
