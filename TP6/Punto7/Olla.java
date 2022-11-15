package TP6.Punto7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Olla {
    private int raciones, capacidadOlla;
    private boolean cocinando;
    private final Lock cerrojo;
    private final Condition hayComida;
    private final Condition noHayComida;
    private final Condition terminoDeCocinar;

    public Olla(int n){
        this.raciones = n;
        this.capacidadOlla = n;
        this.cocinando = false;
        this.cerrojo = new ReentrantLock();
        this.hayComida = cerrojo.newCondition();
        this.noHayComida = cerrojo.newCondition();
        this.terminoDeCocinar = cerrojo.newCondition();
    }

    public boolean vacio(){
        return this.raciones == 0;
    }

    //Metodos de Canibal
    public void comer(){
        this.cerrojo.lock();
        try {
            while(vacio()){
                if(cocinando){
                    this.terminoDeCocinar.await();
                } else{
                    System.out.println("*** "+Thread.currentThread().getName()+": Despierta al cocinero");
                    this.cocinando = true;
                    this.noHayComida.signal();
                    this.hayComida.await();
                    this.terminoDeCocinar.signalAll(); 
                    //Se sirve primero y luego avisa a los demas canibales que hay comida disponible
                }
            }
            this.raciones--;
            System.out.println(Thread.currentThread().getName()+": Se sirvio una racion, raciones ="+raciones);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.cerrojo.unlock();
        }
    }

    //Metodos de Cocinero
    public void cocinar(){
        this.cerrojo.lock();
        try {
            while (!vacio()) {
                this.noHayComida.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void terminarDeCocinar(){
        this.raciones = this.capacidadOlla;
        this.hayComida.signal();
        this.cocinando = false;
        this.cerrojo.unlock();
    }
}
