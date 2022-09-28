package TP3.Punto4;

public class Actividad {
    private String nombre;
    private boolean enUso = false;

    public Actividad(String nom){
        this.nombre = nom;
    }

    public String getNombre() {
        return nombre;
    }

    public synchronized boolean usar() {
        boolean libre = false;
        if(!enUso){
            this.enUso = true;
            libre = true;
        }
        return libre;
    }
    public void dejarDeUsar() {
        this.enUso = false;
    }
    
}
