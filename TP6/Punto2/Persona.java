package TP6.Punto2;

public class Persona implements Runnable{
    private GestorSala gestor;
    private boolean jubilado;

    public Persona(GestorSala g, boolean j){
        this.gestor = g;
        this.jubilado = j;
    }

    public void run(){
        if(jubilado){
            this.gestor.esperarJubilado();
            this.gestor.entrarSalaJubilado();
        }else{
            this.gestor.entrarSala();
        }
        System.out.println("--- "+Thread.currentThread().getName()+" entro a la sala");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.gestor.salirSala();
        System.out.println("--- "+Thread.currentThread().getName()+" salio de la sala");
    }
}
