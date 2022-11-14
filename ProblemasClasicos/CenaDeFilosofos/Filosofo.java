package ProblemasClasicos.CenaDeFilosofos;


public class Filosofo implements Runnable{
    private Mesa mesa;
    private int tenedorIzq;
    private int tenedorDer;

    public Filosofo(Mesa m, int izq, int der){
        this.mesa = m;
        this.tenedorIzq = izq;
        this.tenedorDer = der;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+" usa los tenedores: izquierdo "+tenedorIzq+", derecho "+tenedorDer);
        while(true){
            System.out.println(Thread.currentThread().getName()+" Espera por los tenedores");
            this.mesa.tomarTenedores(tenedorIzq, tenedorDer);
            System.out.println("+++ "+Thread.currentThread().getName()+" Esta usando los tenedores "+tenedorIzq+" y "+tenedorDer);
            try {
                Thread.sleep(3000);
                System.out.println("--- "+Thread.currentThread().getName()+" Dejo de usar los tenedores "+tenedorIzq+" y "+tenedorDer);
                this.mesa.dejarTenedores(tenedorIzq, tenedorDer);
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
