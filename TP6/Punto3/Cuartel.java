package TP6.Punto3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cuartel {
    private int bandejasAlmuerzo, bandejasPostre, abridores;
    final Lock cerrojo = new ReentrantLock();
    final Condition almuerzoDisponible = cerrojo.newCondition();
    final Condition postreDisponible = cerrojo.newCondition();
    final Condition abridorDisponible = cerrojo.newCondition();

    public Cuartel(int alm, int pos, int abr){
        this.bandejasAlmuerzo = alm;
        this.bandejasPostre = pos;
        this.abridores = abr;
    }

    public void tomarAlmuerzo(){
        this.cerrojo.lock();
        try {
            while(bandejasAlmuerzoOcupadas()){
                almuerzoDisponible.await();
            }
            this.bandejasAlmuerzo--;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            this.cerrojo.unlock();
        }
    }
    public void devolverBandejaAlmuerzo(){
        this.cerrojo.lock();
        this.bandejasAlmuerzo++;
        this.almuerzoDisponible.signal();
        this.cerrojo.unlock();
    }

    public void tomarPostre(){
        this.cerrojo.lock();
        try {
            while(bandejasPostreOcupadas()){
                postreDisponible.await();
            }
            this.bandejasPostre--;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            this.cerrojo.unlock();
        }
    }
    public void devolverBandejaPostre(){
        this.cerrojo.lock();
        this.bandejasPostre++;
        this.postreDisponible.signal();
        this.cerrojo.unlock();
    }

    public void usarAbridor(){
        this.cerrojo.lock();
        try {
            while(abridoresOcupados()){
                abridorDisponible.await();
            }
            this.abridores--;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            this.cerrojo.unlock();
        }
    }
    public void devolverAbridor(){
        this.cerrojo.lock();
        this.abridores++;
        this.abridorDisponible.signal();
        this.cerrojo.unlock();
    }

    public boolean bandejasAlmuerzoOcupadas(){
        return bandejasAlmuerzo == 0;
    }
    public boolean bandejasPostreOcupadas(){
        return bandejasPostre == 0;
    }
    public boolean abridoresOcupados(){
        return abridores == 0;
    }

}
