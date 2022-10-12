package ProblemasClasicos.Taxistas;

public class Pasajero implements Runnable{
    private Taxi taxi;

    public Pasajero(Taxi t){
        this.taxi = t;
    }

    public void run(){
        System.out.println("    "+Thread.currentThread().getName()+" buscando un taxi");
        caminar();
        try {
            taxi.pedirTaxi();
            System.out.println("    "+Thread.currentThread().getName()+" despierta al taxista.");
            System.out.println("    "+Thread.currentThread().getName()
                +" se sube al taxi y le indica el destino al taxista.");
            taxi.subirAlTaxi();
            
            taxi.bajarDelTaxi();
            System.out.println("    "+Thread.currentThread().getName()+" se baja del taxi.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void caminar(){
        int random = (int) (Math.random() * 3 + 3);
        try{
            Thread.sleep(random*1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
