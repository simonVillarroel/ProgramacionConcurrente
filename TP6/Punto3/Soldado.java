package TP6.Punto3;

import java.util.Random;

public class Soldado implements Runnable{
    private Cuartel cuartel;

    public Soldado(Cuartel c){
        this.cuartel = c;
    }

    public void run(){
        Random botella = new Random();
        Random postre = new Random();
        boolean quiereBotella = botella.nextBoolean(), quierePostre = postre.nextBoolean();

        System.out.println(Thread.currentThread().getName()+" Quiere almuerzo: con vaso de agua= "+!quiereBotella
            +", con botella de agua= "+quiereBotella+'\n'+"    Quiere postre= "+quierePostre);
        this.cuartel.tomarAlmuerzo();
        System.out.println("+++ "+Thread.currentThread().getName()+" tomo una bandeja de almuerzo");
        if(quiereBotella){
            this.cuartel.usarAbridor();
            System.out.println("+++ "+Thread.currentThread().getName()+" tomo un abridor");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.cuartel.devolverAbridor();
            System.out.println("--- "+Thread.currentThread().getName()+" devolvio el abridor");
        }
        comer();

        this.cuartel.devolverBandejaAlmuerzo();
        System.out.println("--- "+Thread.currentThread().getName()+" devolvio la bandeja de almuerzo");
        
        if(quierePostre){
            this.cuartel.tomarPostre();
            System.out.println("+++ "+Thread.currentThread().getName()+" tomo una bandeja de postre");
            comer();
            this.cuartel.devolverBandejaPostre();
            System.out.println("--- "+Thread.currentThread().getName()+" devolvio la bandeja de postre");
        }
    }

    public void comer(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
