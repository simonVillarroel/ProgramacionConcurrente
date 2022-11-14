package ProblemasClasicos.CenaDeFilosofos;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mesa {
    private boolean[] tenedores;
    private final Lock cerrojo;
    private final Condition tenedoresDisponibles;

    public Mesa(){
        this.tenedores = new boolean[5];
        Arrays.fill(tenedores, true);
        this.cerrojo = new ReentrantLock();
        this.tenedoresDisponibles = cerrojo.newCondition();
    }

    public void tomarTenedores(int izq, int der){
        this.cerrojo.lock();
        try {
           while(!tenedores[izq] || !tenedores[der]){
                this.tenedoresDisponibles.await();
            }
            this.tenedores[izq] = false;
            this.tenedores[der] = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //System.out.println(Arrays.toString(tenedores));
            
            this.cerrojo.unlock();
        }
    }

    public void dejarTenedores(int izq, int der){
        this.cerrojo.lock();
        tenedores[izq] = true;
        tenedores[der] = true;
        this.tenedoresDisponibles.signal();
        this.cerrojo.unlock();
    }
}
