package TP3.Punto3;

import java.util.Random;

public class EmpleadoTerminal implements Runnable{
    private SalaDeConcierto sala;

    public EmpleadoTerminal(SalaDeConcierto s) {
        this.sala = s;       
    }

    public void run() {
        int asiento;
        while(this.enHorario()){
            Random random = new Random();
            asiento = random.nextInt(sala.getAsientosLibresYOcupados().length);
            if(this.sala.reservar(asiento)){
                System.out.println(Thread.currentThread().getName()+": Se reservo el asiento nro: "+asiento);
            }else{
                System.out.println("RESERVADO, no se puede reservar el asiento");
            }
        }
    }

    public boolean enHorario(){
        return true;
    }
}
