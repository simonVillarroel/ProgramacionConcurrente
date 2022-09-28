package TP3.Punto7;

public class Letra implements Runnable{
    private Turno turno;
    private char letra;
    private int impresiones;

    public Letra(Turno t, char l, int i){
        this.turno = t;
        this.letra = l;
        this.impresiones = i;
    }
    
    public void run(){
        while(true){
            if(turno.getTurno() == letra){
                for (int i=0; i<impresiones; i++) {
                    //Hago un sleep para no llenar el output con caracteres tan rapido
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print(letra);
                }
                turno.siguiente(letra);
            }
        }
    }
}
