package TP3.Punto4;

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

    }
    
    public void descansar(int tiempo){
        try {
            System.out.println(Thread.currentThread().getName() + " descansando.");
            Thread.sleep(tiempo);
            System.out.println(Thread.currentThread().getName() + " termino de descansar.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
