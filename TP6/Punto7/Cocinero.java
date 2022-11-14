package TP6.Punto7;

public class Cocinero implements Runnable{
    private Olla olla;

    public Cocinero(Olla o){
        this.olla = o;
    }

    public void run(){
        while(true){
            this.olla.cocinar();
            try {
                System.out.println("/// Cocinero: Cocinando");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("/// Cocinero: Termino de cocinar");
            this.olla.terminarDeCocinar();

        }
    }
}
