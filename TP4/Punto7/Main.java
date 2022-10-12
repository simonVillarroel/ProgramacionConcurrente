package TP4.Punto7;

public class Main {
    public static void main(String[] args) {
        Thread[] arregloCoches = new Thread[25];
        GestorCruce gestor = new GestorCruce();

        //Creacion hiloControl
        HiloControl control = new HiloControl(gestor);
        control.start();
        control.setPriority(Thread.MAX_PRIORITY);
        // Creacion arreglo de coches
        for (int i = 0; i < arregloCoches.length; i++) {
            Coche hiloCoche = new Coche(gestor, "Coche" + (i + 1));
            hiloCoche.start();
            arregloCoches[i] = hiloCoche;
        }
    }
}
