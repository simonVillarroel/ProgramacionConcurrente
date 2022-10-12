package ProblemasClasicos.ProductorConsumidor;

public class Productor implements Runnable{
    private Buffer buffer;

    public Productor(Buffer b){
        this.buffer = b;
    }

    public void run(){
        while(true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            buffer.producir();
        }
    }
}
