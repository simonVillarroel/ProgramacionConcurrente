package TP5.Punto2;

public class Main {
    public static void main(String[] args) {
        int cantidadPerros = 100;
        int cantidadGatos = 100;
        int cantidadAnimales = 5;

        Comedor comedor = new Comedor(3);
        Thread[] perros = new Thread[cantidadPerros];
        Thread[] gatos = new Thread[cantidadGatos];

        //Creacion de los hilos perros
        for(int i =0; i < cantidadPerros; i++){
            Perro runPerro = new Perro(comedor, "Perro");
            Thread hiloPerro = new Thread(runPerro, "Perro"+(i+1));
            perros[i] = hiloPerro;
            hiloPerro.start();
        }

        //Creacion de los hilos gatos
        for(int i =0; i < cantidadGatos; i++){
            Gato runGato = new Gato(comedor, "Gato");
            Thread hiloGato = new Thread(runGato, "Gato"+(i+1));
            gatos[i] = hiloGato;
            hiloGato.start();
        }
        
        //Creacion de los hilos de ambos animales
        /*for(int i =0; i < cantidadAnimales; i++){
            Perro runPerro = new Perro(comedor, "Perro");
            Gato runGato = new Gato(comedor, "Gato");
            Thread hiloPerro = new Thread(runPerro, "Perro"+(i+1));
            Thread hiloGato = new Thread(runGato, "Gato"+(i+1));
            perros[i] = hiloPerro;
            gatos[i] = hiloGato;
            hiloPerro.start();
            hiloGato.start();
        }*/
    }
}
