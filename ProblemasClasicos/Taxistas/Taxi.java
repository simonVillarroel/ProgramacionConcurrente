package ProblemasClasicos.Taxistas;

import java.util.concurrent.Semaphore;

class Taxi{
    private Semaphore semPasajero;
    private Semaphore semTaxista;
    private Semaphore semLlegada;

    public Taxi(){
        this.semPasajero = new Semaphore(0);
        this.semTaxista = new Semaphore(0);
        this.semLlegada = new Semaphore(0);
    }

    //Metodos utilizados por el pasajero
    public void pedirTaxi() throws InterruptedException{
        semTaxista.acquire();
    }
    public void subirAlTaxi() throws InterruptedException{
        semPasajero.release();
    }
    public void bajarDelTaxi() throws InterruptedException{
        semLlegada.acquire();
    }

    //Metodos utilizados por el taxista
    public void disponible() throws InterruptedException{
        semTaxista.release();
    }
    public void preguntarDestino() throws InterruptedException{
        semPasajero.acquire();
    }
    public void llegada(){
        semLlegada.release();
        
    }
}
