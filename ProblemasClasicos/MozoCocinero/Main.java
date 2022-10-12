package ProblemasClasicos.MozoCocinero;

public class Main {
    public static void main(String[] args) {
        int cantidadMozos = 2;
        Mozo[] arregloMozos = new Mozo[cantidadMozos];
        Comida comida = new Comida();
        Cocinero hiloCocinero = new Cocinero(comida, "Cocinero1");
        hiloCocinero.start();

        for (int i=0; i<cantidadMozos; i++) {	
            Mozo hiloMozo = new Mozo(comida, "Mozo "+(i+1));
            hiloMozo.start();
            arregloMozos[i]= hiloMozo;
        }
    }
}
