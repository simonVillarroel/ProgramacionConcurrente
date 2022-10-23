package TPO.Punto1;

public class Auto implements Runnable{
    private Transbordador transbordador;

    public Auto(Transbordador t){
        this.transbordador = t;
    }

    public void run(){
        try {
            this.transbordador.subir();
            System.out.println(Thread.currentThread().getName()+": Subió al transbordador");
            this.transbordador.puedeSubir();
            this.transbordador.bajar();
            System.out.println(Thread.currentThread().getName()+": Bajó del transbordador");
            this.transbordador.puedeBajar();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
