package TP6.Punto7;

public class Main {
    public static void main(String[] args) {
        Thread[] canibales = new Thread[100];
        Olla olla = new Olla(20);
        Cocinero cocinero = new Cocinero(olla);
        Thread hiloCocinero = new Thread(cocinero);

        //Creacion de los hilos Persona
        for(int i =0; i < canibales.length; i++){
            Canibal canibal= new Canibal(olla); 
            Thread hiloCanibal = new Thread(canibal, "Canibal"+i);
            canibales[i] = hiloCanibal;
            hiloCanibal.start();
        }
        hiloCocinero.start();
    }
}
