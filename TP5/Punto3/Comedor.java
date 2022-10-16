package TP5.Punto3;

import java.util.concurrent.Semaphore;

public class Comedor {
    private Semaphore comederos;
    private Semaphore semEntrada;
    private int cantComederos;
    private String turno;

    public Comedor(int cant){
        this.cantComederos = cant;
        this.comederos = new Semaphore(cantComederos);
        this.semEntrada = new Semaphore(1);
        this.turno = "";
    }

    public boolean entrar(String especie) throws InterruptedException{
        boolean exito = false;
        if(semEntrada.tryAcquire(1)){
            exito = true;
            if(especie == "Perro"){
                System.out.println("Turno de los perros.");
                this.turno = "Perro";
            }else{
                System.out.println("Turno de los gatos.");
                this.turno = "Gato";
            }
        }
        return exito;
    }

    public boolean comer(int permisos) throws InterruptedException{
        boolean exito = false;
        if(comederosLlenos()){
            this.turno = "";
        }else{
            comederos.acquire(permisos);
            exito = true;
        }
        return exito;
    }
    public boolean comederosLlenos(){
        boolean lleno = false;
        if (turno == "Perro") {
            if (comederos.availablePermits() <= 1) {
                lleno = true;
            }
        }else{
            if (comederos.availablePermits() == 0) {
                lleno = true;
            }
        }
        return lleno;
    }
    
    public void dejarComer(int permisos){
        comederos.release(permisos);
        System.out.println(comederos.availablePermits());
        if(comederos.availablePermits() == cantComederos){
            this.turno = "";
            semEntrada.release();
        }
    }

    public String getTurno() {
        return turno;
    }

}
