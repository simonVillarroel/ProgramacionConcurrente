package TP3.Punto5;

public class Surtidor {
    private int litrosDisponibles;

    public Surtidor(int max){
        this.litrosDisponibles = max;
    }

    public synchronized boolean cargarCombustible(int cantidad){
        boolean exito = false;
        if(litrosDisponibles >= cantidad){
            this.litrosDisponibles -= cantidad;
            System.out.println(Thread.currentThread().getName()+"---Estado del surtidor: "+this.litrosDisponibles+" litros disponibles.");
            exito = true;
        }
        return exito;
    }

}
