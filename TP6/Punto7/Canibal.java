package TP6.Punto7;

public class Canibal implements Runnable{
    private Olla olla;

    public Canibal(Olla o){
        this.olla = o;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+": Esperando para servirse comida");
        this.olla.comer();
        //System.out.println(Thread.currentThread().getName()+": Se sirvio una racion");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+": Termino de comer");
    }
}
