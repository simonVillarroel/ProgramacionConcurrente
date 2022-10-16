package TP5.Punto3;

public class Perro implements Runnable{
    private Comedor comedor;
    private String especie;

    public Perro(Comedor com, String es){
        this.comedor = com;
        this.especie = es;
    }

    public void run(){
        boolean comio = false;
        
        while(!comio){
            try {
                if(comedor.getTurno() == especie || comedor.entrar(especie)){
                    if(comedor.comer(2)){
                        System.out.println("+P+ "+Thread.currentThread().getName()+" comiendo.");
                        Thread.sleep(5000);
                        System.out.println("+P+ "+Thread.currentThread().getName()+" termino de comer.");
                        comedor.dejarComer(2);
                        comio = true;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}