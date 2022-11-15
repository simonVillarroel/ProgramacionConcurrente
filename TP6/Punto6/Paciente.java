package TP6.Punto6;

public class Paciente implements Runnable{
    private CentroHemoterapia centro;

    public Paciente(CentroHemoterapia c){
        this.centro = c;
    }

    public void run(){
        this.centro.entrarCentro();
        System.out.println("- "+Thread.currentThread().getName()+": Entro a la sala de espera");
        this.centro.esperarCamilla();
        System.out.println("- "+Thread.currentThread().getName()+": Comienza el tratamiento");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.centro.salirCentro();
        System.out.println("- "+Thread.currentThread().getName()+": Salio del centro de hemoterapia.");
    }
}
