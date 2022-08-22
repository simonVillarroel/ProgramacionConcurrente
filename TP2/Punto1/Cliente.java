package TP2.Punto1;

public class Cliente extends Thread{
    public void run(){
        System.out.println("Soy "+Thread.currentThread().getName());
        Recurso.uso();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
}