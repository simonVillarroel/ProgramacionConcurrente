package TP5.Punto7;

public class Babuino implements Runnable{
    private Cuerda cuerda;
    private char lado;

    public Babuino(Cuerda c, char l){
        this.cuerda = c;
        this.lado = l;
    }

    public void run(){
        try {
            cuerda.esperar(lado);
            System.out.println("+++ "+Thread.currentThread().getName()+" Esperando para cruzar desde lado "+lado);
            cuerda.cruzar(lado);
            System.out.println("+++ "+Thread.currentThread().getName()+" Cruzando desde lado "+lado);
            Thread.sleep(3000);
            System.out.println("+++ "+Thread.currentThread().getName()+" Termino de cruzar "+lado);
            cuerda.terminarCruce(lado);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
