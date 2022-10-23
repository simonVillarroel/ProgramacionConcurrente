package TPO.Punto1;

public class ControlTransbordador implements Runnable{
    private Transbordador transbordador;

    public ControlTransbordador(Transbordador t){
        this.transbordador = t;
    } 

    public void run(){
        while(true){
            try {
                System.out.println("/////////////////////////////////");
                this.transbordador.liberarEntrada();
                this.transbordador.comenzarViaje();
                System.out.println(Thread.currentThread().getName()+": Viajando.");
                Thread.sleep(5000);
                this.transbordador.llegoOeste();
                this.transbordador.liberarSalida();
                this.transbordador.comenzarViaje();
                System.out.println(Thread.currentThread().getName()+": Viajando sin autos.");
                Thread.sleep(5000);
                this.transbordador.llegoEste();
                System.out.println("/////////////////////////////////");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}