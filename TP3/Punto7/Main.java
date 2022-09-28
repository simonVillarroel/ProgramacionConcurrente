package TP3.Punto7;

public class Main {
    public static void main(String[] args) {
        Turno turno = new Turno();
        Letra runA = new Letra(turno, 'A', 2);
        Letra runB = new Letra(turno, 'B', 3);
        Letra runC = new Letra(turno, 'C', 4);
        Thread hiloA = new Thread(runA);
        Thread hiloB = new Thread(runB);
        Thread hiloC = new Thread(runC);
        hiloA.start(); hiloB.start(); hiloC.start();
    }
}
