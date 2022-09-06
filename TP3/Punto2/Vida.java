package TP3.Punto2;

public class Vida {
    private int puntosVida = 10;
    
    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public void modificarVida(int cantidad){
        this.puntosVida += cantidad;
    }
}
