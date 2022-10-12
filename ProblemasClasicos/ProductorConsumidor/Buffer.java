package ProblemasClasicos.ProductorConsumidor;

import java.util.concurrent.Semaphore;

public class Buffer {
    private Semaphore buffer, mutex;
    private int tope;
    private boolean lleno;

    public Buffer(){
        this.buffer = new Semaphore(0);
        this.mutex = new Semaphore(1);
        this.tope = 10;
        this.lleno = false;
    }

    public void producir(){
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(!lleno){
            buffer.release();
            System.out.println(Thread.currentThread().getName()+" agrego producto: "+buffer.availablePermits()+" disponibles");
            tope++;
            if(buffer.availablePermits() == tope){
                lleno = true;
            }
        }
        mutex.release();
    }

    public void consumir(){
        try {
            buffer.acquire();
            System.out.println(Thread.currentThread().getName()+" consumio producto: ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
