package TP6.Punto7;

public class Canibal implements Runnable{
    private Olla olla;

    public Canibal(Olla o){
        this.olla = o;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+": Esperando para servirse comida");
        this.olla.comer();
        //Falta resolver problemas de responsabilidad al mostrar mensajes
    }
}
