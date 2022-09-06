package TP3.Punto2;

public class Main {
    public static void main(String[] args) {
        Vida vida = new Vida();
        Orco hiloOrco = new Orco(vida);
        Curandero hiloCurandero = new Curandero(vida);
        hiloOrco.start();
        hiloCurandero.start();
    }
}
