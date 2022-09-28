package TP3.Punto5;

import java.util.Random;

public class Auto extends Vehiculo implements Runnable{
    private double tanqueCombustible;
    private double reserva;
    private Surtidor surtidor;

    public Auto(String pat, String mod, String mar, int km, double litros, Surtidor surt){
        super(pat, mod, mar, km);
        this.tanqueCombustible = litros;
        this.reserva = tanqueCombustible/7;
        this.surtidor = surt;
    }

    public void run(){
        int i =0, kilometros;
        Random km = new Random();
        while(i < 5){
            kilometros = km.nextInt(100);
            if(this.tanqueCombustible >= this.reserva && (this.tanqueCombustible - kilometros/2)>0){
                recorrer(kilometros);
            }else{
                cargarCombustible();
                recorrer(kilometros);
            }
            i++;
        }
    }

    public void recorrer(int km){
        try {
            System.out.println("Auto patente "+this.getPatente()+" recorriendo "+km+" kilometros");
            Thread.sleep(km*100);
            this.aumentarKm(km);
            this.tanqueCombustible -= km/2;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cargarCombustible(){
        boolean exito = this.surtidor.cargarCombustible(50);
        this.tanqueCombustible += 50;
        if(!exito){
            System.out.println("No hay combustible suficiente.");
        }
    }
}
