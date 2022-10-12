package TP4.Punto7;

public class HiloControl extends Thread{
    private GestorCruce gestor;

    public HiloControl(GestorCruce ges){
        this.gestor = ges;
    }

    public void run(){
        while (true) {
            for (int senial = 0; senial <= 1; senial++) {
                try {
                    Thread.sleep(500);
                    this.gestor.cambiaSemaforos(senial);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
