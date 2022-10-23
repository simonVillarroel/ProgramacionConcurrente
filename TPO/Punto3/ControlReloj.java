package TPO.Punto3;

public class ControlReloj implements Runnable{
    private Reloj reloj;

    public ControlReloj(Reloj r){
        this.reloj = r;
    }

    public void run(){
        while(true){
            try {
                Thread.sleep(5000);
                this.reloj.incrementarHora();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
