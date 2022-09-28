package TP3.Punto4;

import java.util.Random;

public class Hamster implements Runnable{
    private Jaula jaula;

    public Hamster(Jaula jaula){
        this.jaula = jaula;
    }

    public void run(){

        System.out.println();
        comer();
        ejercitar(jaula.getRueda().getTiempoDeEjercicio());
        descansar(jaula.getHamaca().getTiempoDeDescanso());

    }

    public void comer(){
        System.out.println(Thread.currentThread().getName() + " comiendo.");
        jaula.getPlato().comer();
        System.out.println(Thread.currentThread().getName() + " termino de comer.");
    }

    public void ejercitar(int tiempo){
            System.out.println(Thread.currentThread().getName() + " ejercitando.");
            jaula.getRueda().ejercitar();
            System.out.println(Thread.currentThread().getName() + " termino de ejercitar.");

        int actividad;
        Random random = new Random();
        //Cada Hamster intentara realizar las distintas actividades indefinidamente
        while(true){
            actividad = random.nextInt(3);
            //La seleccion de la actividad se realiza de manera aleatoria
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

    public void comer(){
        boolean exito = jaula.getPlato().usar();
        if (exito){
            System.out.println(Thread.currentThread().getName() + " comiendo.");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("---"+ Thread.currentThread().getName() + " termino de comer.");
            jaula.getPlato().dejarDeUsar();
        }
    }

    public void ejercitar(){
        boolean exito = jaula.getRueda().usar();
        if (exito){
            System.out.println(Thread.currentThread().getName() + " ejercitando.");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("---"+ Thread.currentThread().getName() + " termino de ejercitar.");
            jaula.getRueda().dejarDeUsar();
        }
    }
    
    public void descansar(){
        boolean exito = jaula.getHamaca().usar();
        if (exito){
            System.out.println(Thread.currentThread().getName() + " descansando.");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("---"+ Thread.currentThread().getName() + " termino de descansar.");
            jaula.getHamaca().dejarDeUsar();
        }
    }    
}
