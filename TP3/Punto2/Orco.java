package TP3.Punto2;

public class Orco extends Thread{
    private Vida vida;

    public Orco(Vida hp){
        this.vida = hp;
    }

    public void run() {
        for(int i =0; i<=4; i++){
            synchronized (vida){
                System.out.println("El Orco se prepara para golpear.");
                if(vida.getPuntosVida() > 0){
                    vida.modificarVida(-3);
                    System.out.println("El orco golpeó: -3 puntos de vida."+ '\n' + "Vida actual: "
                        + vida.getPuntosVida());
                }else{
                    System.out.println("El orco no puede golpear, el personaje no tiene puntos de vida.");
                    i = 5;
                }
            }
        }
        System.out.println("El orco se fue.");
    }
}
