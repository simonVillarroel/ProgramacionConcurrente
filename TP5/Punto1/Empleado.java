package TP5.Punto1;

public class Empleado implements Runnable{
    private Confiteria confiteria;

    public Empleado(Confiteria confi){
        this.confiteria = confi;
    }

    public void run(){
        System.out.println("   --- "+Thread.currentThread().getName()+" esperando un asiento");
        try {
            confiteria.sentarse();
            System.out.println("   --- "+Thread.currentThread().getName()+" se sento");
            int random = (int) (Math.random() * 3);
            switch (random) {
                case 0:
                    System.out.println("   --- "+Thread.currentThread().getName()+" ordeno una bebida");
                    beber();
                    break;
                case 1:
                    System.out.println("   --- "+Thread.currentThread().getName()+" ordeno una comida");
                    comer();
                    break;
                case 2:
                    System.out.println("   --- "+Thread.currentThread().getName()+" ordeno comida y bebida");
                    beber();
                    comer();
                    break;
            
                default:
                    break;
            }
            System.out.println("   --- "+Thread.currentThread().getName()+" deja el asiento");
            confiteria.dejarAsiento();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void beber() throws InterruptedException{
        System.out.println("   --- "+Thread.currentThread().getName()+" llama al mozo.");
        confiteria.llamarMozo();
        confiteria.tomarBebida();
        System.out.println("   --- "+Thread.currentThread().getName()+" bebiendo.");
        consumir();
        System.out.println("   --- "+Thread.currentThread().getName()+" termino de beber.");
    }

    public void comer() throws InterruptedException{
        System.out.println("   --- "+Thread.currentThread().getName()+" llama al cocinero.");
        confiteria.llamarCocinero();
        confiteria.tomarComida();
        System.out.println("   --- "+Thread.currentThread().getName()+" comiendo.");
        consumir();
        System.out.println("   --- "+Thread.currentThread().getName()+" termino de comer.");
    }

    public void consumir(){
        int random = (int) (Math.random() * 3 + 3);
        try{
            Thread.sleep(random*1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
