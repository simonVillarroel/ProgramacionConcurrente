package TP6.Punto6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CentroHemoterapia {
    private int camillas, revistas, lugaresSalaEspera;
    private final Lock cerrojo;
    private final Condition camillasLibres, hayLugarSalaEspera;

    public CentroHemoterapia(){
        this.camillas = 4;
        this.revistas = 9;
        this.lugaresSalaEspera = 15;
        this.cerrojo = new ReentrantLock(true);
        this.camillasLibres = cerrojo.newCondition();
        this.hayLugarSalaEspera = cerrojo.newCondition();
    }

    public boolean camillasOcupadas(){
        return camillas == 0;
    }

    public boolean revistasOcupadas(){
        return revistas == 0;
    }
    public boolean salaEsperaLlena(){
        return this.lugaresSalaEspera == 0;
    }

    public void entrarCentro(){
        this.cerrojo.lock();
        try {
            while(salaEsperaLlena()){
                this.hayLugarSalaEspera.await();
            }
            this.lugaresSalaEspera--;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.cerrojo.unlock();
        }
    }

    public void esperarCamilla(){
        boolean tieneRevista = false;
        this.cerrojo.lock();
        try {
            while(camillasOcupadas()){
                if(!revistasOcupadas() && tieneRevista == false){
                    this.revistas--;
                    tieneRevista = true;
                    System.out.println("+++ "+Thread.currentThread().getName()+": Toma una revista, "+this.revistas+" revistas disponibles");
                }else{
                    System.out.println(Thread.currentThread().getName()+": Mira TV");
                }
                this.camillasLibres.await();
            }
            System.out.println("** "+Thread.currentThread().getName()+": Ocupa una camilla");
            this.camillas--;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(tieneRevista){
                this.revistas++;
                System.out.println("+++ "+Thread.currentThread().getName()+
                    ": Libera la revista que tenia, "+this.revistas+" revistas disponibles");
            }
            this.cerrojo.unlock();
        }
    }

    public void salirCentro(){
        this.cerrojo.lock();
        this.camillas++;
        this.lugaresSalaEspera++;
        this.camillasLibres.signalAll();
        this.hayLugarSalaEspera.signal();
        this.cerrojo.unlock();
    }
}
