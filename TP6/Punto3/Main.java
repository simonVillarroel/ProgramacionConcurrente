package TP6.Punto3;

public class Main {
    public static void main(String[] args) {
        Thread[] soldados = new Thread[50];
        Cuartel cuartel = new Cuartel(5, 3, 10);
       
        //Creacion de los hilos Soldado
        for(int i =0; i < soldados.length; i++){
            Soldado soldado = new Soldado(cuartel);
            Thread hiloSoldado = new Thread(soldado, "Soldado"+i);
            soldados[i] = hiloSoldado;
            hiloSoldado.start();
        }
    }
}
