package TP3.HamstersConSemaforo;

import java.util.Random;

public class Hamster implements Runnable{
    private Jaula jaula;

    public Hamster(Jaula jaula) {
        this.jaula = jaula;
    }

    public void run() {
        int actividad;
        Random random = new Random();
        // Cada Hamster intentara realizar las distintas actividades indefinidamente
        while (true) {
            actividad = random.nextInt(3);
            // La seleccion de la actividad se realiza de manera aleatoria
            switch (actividad) {
                case 0:
                    comer();
                    break;
                case 1:
                    ejercitar();
                    break;
                case 2:
                    descansar();
                    break;
                default:
                    break;
            }

        }
    }

    public void comer() {
        jaula.usarPlato();
        System.out.println(Thread.currentThread().getName() + " comiendo.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---" + Thread.currentThread().getName() + " termino de comer.");
        jaula.liberarPlato();

    }

    public void ejercitar() {
        jaula.usarRueda();

        System.out.println(Thread.currentThread().getName() + " ejercitando.");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---" + Thread.currentThread().getName() + " termino de ejercitar.");
        jaula.liberarRueda();

    }

    public void descansar() {
        jaula.usarHamaca();
        System.out.println(Thread.currentThread().getName() + " descansando.");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---" + Thread.currentThread().getName() + " termino de descansar.");
        jaula.liberarHamaca();
    }
}
