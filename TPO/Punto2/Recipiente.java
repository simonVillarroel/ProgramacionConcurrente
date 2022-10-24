package TPO.Punto2;

import java.util.concurrent.Semaphore;

public class Recipiente {
    private int capacidad, capacidadTotal;
    private Semaphore llenar, distribuir;

    public Recipiente(int total){
        this.capacidad = 0;
        this.capacidadTotal = total;
        this.llenar = new Semaphore(1);
        this.distribuir = new Semaphore(0);
    }

    public boolean lleno(){
        return this.capacidad == this.capacidadTotal;
    }

    public void agregarAgua() throws InterruptedException{
        this.llenar.acquire();
        this.capacidad++;
        System.out.println("    ***Capacidad actual Recipiente: "+this.capacidad+"/"+this.capacidadTotal);
        if(this.lleno()){
            this.distribuir.release();
        }else{
            this.llenar.release();
        }

    }

    public void distribuirAgua() throws InterruptedException {
        this.distribuir.acquire();
        this.capacidad = 0; //Se vacía el recipiente
        System.out.println("Recipiente vacio.");
        System.out.println();
        this.llenar.release();
    }
}
