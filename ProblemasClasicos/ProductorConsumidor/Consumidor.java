package ProblemasClasicos.ProductorConsumidor;

public class Consumidor implements Runnable{
    private Buffer buffer;

    public Consumidor(Buffer b){
        this.buffer = b;
    }

    public void run(){
        buffer.consumir();
    }
}
