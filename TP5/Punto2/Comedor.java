package TP5.Punto2;

import java.util.concurrent.Semaphore;

public class Comedor {
    private int cantComederos;
    private Semaphore comederos;
    private Semaphore semEntrada;
    private String turno;

    public Comedor(int cant){
        this.cantComederos = cant;
        this.comederos = new Semaphore(cantComederos);
        this.semEntrada = new Semaphore(1);
        this.turno = "";
    }

    public boolean entrar(String especie){
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

    public boolean comederosLlenos(){
        return (comederos.availablePermits() == 0);
    }

    public boolean comer() throws InterruptedException{
        boolean exito = false;
        if(comederosLlenos()){
            this.turno = "";
        }else{
            comederos.acquire();
            exito = true;
        }
        return exito;
    }

    public void dejarComer(){
        comederos.release();
        if(comederos.availablePermits()== 3){
            this.turno = "";
            semEntrada.release();
        }
    }

    public String getTurno() {
        return turno;
    }

}
