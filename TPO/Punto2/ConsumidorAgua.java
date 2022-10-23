package TPO.Punto2;

public class ConsumidorAgua implements Runnable{
    private Espacio espacio;
    private Recipiente recipiente;

    public ConsumidorAgua(Espacio e, Recipiente r){
        this.espacio = e;
        this.recipiente = r;
    }

    public void run(){
        while(true){
            try {
                if(this.recipiente.lleno()){
                    System.out.println(Thread.currentThread().getName()+": Recipiente lleno, distribuye agua.");
                    this.recipiente.distribuirAgua();
                }
                this.espacio.hacerAgua();
                System.out.println(Thread.currentThread().getName()+": Hizo agua.");
                this.recipiente.agregarAgua();
                System.out.println(Thread.currentThread().getName()+": Agrego agua al recipiente.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
