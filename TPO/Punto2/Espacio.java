package TPO.Punto2;

import java.util.concurrent.Semaphore;

public class Espacio {
    private int cantHidrogeno, cantOxigeno;
    private Semaphore Olisto, Hlisto, oxigenoUsado, hidrogenoUsado;
    private Semaphore oxigenoDisponible, hidrogenoDisponible, hacerAtomo;

    public Espacio(){
        this.cantHidrogeno = 0;
        this.cantOxigeno = 0;
        this.Olisto = new Semaphore(0);
        this.Hlisto = new Semaphore(0);
        this.oxigenoUsado = new Semaphore(0);
        this.hidrogenoUsado = new Semaphore(0);
        this.oxigenoDisponible = new Semaphore(1);
        this.hidrogenoDisponible = new Semaphore(2);
        this.hacerAtomo = new Semaphore(0); 
    }

    //Metodos Generador
    public void hacerAtomos() throws InterruptedException{
        if (this.cantHidrogeno >= 2 && this.cantOxigeno >= 1) {
            System.out.println("//////////////Generador bloqueado");
            this.hacerAtomo.acquire();
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

    //Metodos de Atomo
    public void liberarOxigeno() throws InterruptedException{
        this.oxigenoDisponible.acquire();
        this.Olisto.release();
    }

    public void liberarHidrogeno() throws InterruptedException{
        this.hidrogenoDisponible.acquire();
        this.Hlisto.release();
    }

    public void usarAtomo(String tipo) throws InterruptedException{
        if(tipo == "Hidrogeno"){
            this.hidrogenoUsado.acquire();
            this.cantHidrogeno--;
            this.hidrogenoDisponible.release();
        }else{
            this.oxigenoUsado.acquire();
            this.cantOxigeno--;
            this.oxigenoDisponible.release();
        }
    }

    //Metodos de ConsumidorAgua
    public void hacerAgua() throws InterruptedException{
        this.Hlisto.acquire(2);
        this.Olisto.acquire();
        this.hidrogenoUsado.release(2);
        this.oxigenoUsado.release();

        ///
        this.hacerAtomo.release();
    }
}
