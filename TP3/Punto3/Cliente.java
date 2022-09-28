package TP3.Punto3;

public class Cliente extends Thread{
    private SalaDeConcierto sala;
    private String nombre;

    public Cliente(SalaDeConcierto s, String n) {
        this.sala = s;
        this.nombre = n;        
    }

    public SalaDeConcierto getSala() {
        return sala;
    }
    public String getNombre() {
        return nombre;
    }
}
