package TPO.Punto2;

import java.util.concurrent.Semaphore;

public class Espacio {
    private int cantHidrogeno, cantOxigeno;
    private Semaphore Olisto, Hlisto, oxigenoUsado, hidrogenoUsado;
    private Semaphore OlistoDisponible, HlistoDisponible, hacerAtomo;

    public Espacio(){
        this.cantHidrogeno = 0;
        this.cantOxigeno = 0;
        this.Olisto = new Semaphore(0);
        this.Hlisto = new Semaphore(0);
        this.oxigenoUsado = new Semaphore(0);
        this.hidrogenoUsado = new Semaphore(0);
        this.OlistoDisponible = new Semaphore(1);
        this.HlistoDisponible = new Semaphore(2);
        this.hacerAtomo = new Semaphore(0); 
    }

    //Métodos de GeneradorDeAtomos
    public void hacerAtomos() throws InterruptedException{
        if (this.cantHidrogeno > 2 && this.cantOxigeno > 1) {
            System.out.println("//////////////Generador bloqueado");
            this.hacerAtomo.acquire(); //Bloquea la producción de átomos
        }
    }
    
    public int getCantHidrogeno() {
        return cantHidrogeno;
    }
    public void incrementarHidrogeno(){
        this.cantHidrogeno++;
    }
    public int getCantOxigeno() {
        return cantOxigeno;
    }
    public void incrementarOxigeno(){
        this.cantOxigeno++;
    }

    //Métodos de Atomo
    public void liberarOxigeno() throws InterruptedException{
        this.OlistoDisponible.acquire();
        //Un átomo de Oxígeno entra a Olisto
        this.Olisto.release();
    }

    public void liberarHidrogeno() throws InterruptedException{
        this.HlistoDisponible.acquire();
        //Un átomo de Hidrógeno entra a Hlisto
        this.Hlisto.release();
    }

    public void usarAtomo(String tipo) throws InterruptedException{
        if(tipo == "Hidrogeno"){
            this.hidrogenoUsado.acquire();
            //Un átomo de Oxígeno es consumido
            this.cantHidrogeno--;
            this.HlistoDisponible.release();
        }else{
            this.oxigenoUsado.acquire();
            //Un átomo de Hidrógeno es consumido
            this.cantOxigeno--;
            this.OlistoDisponible.release();
        }
    }

    //Métodos de ConsumidorAgua
    public void hacerAgua() throws InterruptedException{
        //Espera por Hlisto y Olisto y produce agua
        this.Hlisto.acquire(2);
        this.Olisto.acquire();
        this.hidrogenoUsado.release(2);
        this.oxigenoUsado.release();

        this.hacerAtomo.release(); //Libera la producción de átomos
    }
}
