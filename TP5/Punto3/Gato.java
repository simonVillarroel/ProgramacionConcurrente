package TP5.Punto3;

public class Gato implements Runnable{
    private Comedor comedor;
    private String especie;

    public Gato(Comedor com, String es){
        this.comedor = com;
        this.especie = es;
    }

    public void run(){
        boolean comio = false;
        
        while(!comio){
            try {
                if(comedor.getTurno() == especie || comedor.entrar(especie)){
                    if(comedor.comer(1)){
                        System.out.println("-G- "+Thread.currentThread().getName()+" comiendo.");
                        Thread.sleep(5000);
                        System.out.println("-G- "+Thread.currentThread().getName()+" termino de comer.");
                        comedor.dejarComer(1);
                        comio = true;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
