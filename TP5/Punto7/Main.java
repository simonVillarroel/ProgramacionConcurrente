package TP5.Punto7;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int cantBabuinos = 30, lado = -1;
        Babuino babuino;
        Random random = new Random();
        Cuerda cuerda = new Cuerda();

        //Creacion de los hilos Babuinos aleatoriamente
        /*for(int i =0; i < cantBabuinos; i++){
            lado = random.nextInt(2);
            if(lado == 0){
                babuino = new Babuino(cuerda, 'A');
            }else{
                babuino = new Babuino(cuerda, 'B');
            }
            Thread hiloBabuino = new Thread(babuino, "Babuino"+(i));
            hiloBabuino.start();
        }*/

        //Creacion de los hilos Babuinos de lado A
        for(int i =0; i < 20; i++){
            babuino = new Babuino(cuerda, 'A');
            Thread hiloBabuino = new Thread(babuino, "Babuino"+(i));
            hiloBabuino.start();
        }
        //Creacion de los hilos Babuinos de lado B
        for(int i =0; i < 20; i++){
            babuino = new Babuino(cuerda, 'B');
            Thread hiloBabuino = new Thread(babuino, "Babuino"+(i));
            hiloBabuino.start();
        }
    }
}
