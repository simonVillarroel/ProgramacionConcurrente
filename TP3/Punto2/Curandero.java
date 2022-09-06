package TP3.Punto2;

public class Curandero extends Thread{
    private Vida vida;

    public Curandero(Vida hp){
        this.vida = hp;
    }

    public void run() {
        for(int i =0; i<=4; i++){
            synchronized (vida){
                System.out.println("El Curandero se prepara para curar.");
                if(vida.getPuntosVida() > 0){
                    vida.modificarVida(3);
                    System.out.println("El curandero lanzó curación: +3 puntos de vida."+ '\n' + "Vida actual: "
                        + vida.getPuntosVida());
                }else{
                    System.out.println("El curandero no puede lanzar curación, el personaje no tiene puntos de vida.");
                    i = 5;
                }
            }
        }
        if(vida.getPuntosVida() > 0)
            System.out.println("El Curandero se quedó sin maná.");
    }
}
