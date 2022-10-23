package TPO.Punto3;

public class Durmiente implements Runnable{
    private Reloj reloj;
    private int horaDesde, cantHorasTrabajo;

    public Durmiente(Reloj r, int desde, int cantidad){
        this.reloj = r;
        this.horaDesde = desde;
        this.cantHorasTrabajo = cantidad;
    }

    public void run(){
        while(true){
            this.reloj.trabajar(horaDesde);
            this.reloj.decrementarTotalDurmientes();
            System.out.println("    "+Thread.currentThread().getName()+": Entre a trabajar.");
            try {
                Thread.sleep(cantHorasTrabajo*5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("    "+Thread.currentThread().getName()+": Sali del trabajo, me voy a dormir.");
            this.reloj.incrementarTotalDurmientes();
        }
    }
}
