package TP2.Punto4;

public class ThreadEjemploConRunnable implements Runnable{
    public void run(){
        for(int i=0; i<10; i++)
            System.out.println(i+" "+ Thread.currentThread().getName());
        System.out.println("Termina Thread "+ Thread.currentThread().getName());
    }
    
    public static void main(String[] args) {
        Runnable hiloJose = new ThreadEjemploConRunnable();
        Runnable hiloMaria = new ThreadEjemploConRunnable();
        new Thread(hiloJose, "Jose Maria").start();
        new Thread(hiloMaria, "Maria Jose").start();
        System.out.println("Termina thread main");
    }
}
