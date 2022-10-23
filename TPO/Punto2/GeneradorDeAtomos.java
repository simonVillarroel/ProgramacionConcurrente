package TPO.Punto2;

import java.util.Random;

public class GeneradorDeAtomos implements Runnable{
    private Espacio espacio;

    public GeneradorDeAtomos(Espacio e){
        this.espacio = e;
    }

    public void run(){
        int r, cont = 1;
        while(true){
            Random random = new Random();
            r = random.nextInt(2);
            Atomo atomo;
            try {
                this.espacio.hacerAtomos();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            if(r == 0){
                if(this.espacio.getCantHidrogeno() < 10){
                    System.out.println(Thread.currentThread().getName()+ ": Generando atomo de Hidrogeno.");
                    atomo = new Atomo(espacio, "Hidrogeno");
                    Thread hiloAtomo = new Thread(atomo, "Atomo"+cont);
                    hiloAtomo.start();
                    this.espacio.incrementarHidrogeno();
                    cont++;
                }
            }else{
                if(this.espacio.getCantOxigeno() < 5){
                    System.out.println(Thread.currentThread().getName()+ ": Generando atomo de Oxigeno.");
                    atomo = new Atomo(espacio, "Oxigeno");
                    Thread hiloAtomo = new Thread(atomo, "Atomo"+cont);
                    hiloAtomo.start();
                    this.espacio.incrementarOxigeno();
                    cont++;
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
