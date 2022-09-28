package TP3.Punto3;

import java.util.Arrays;

public class SalaDeConcierto {
    private boolean[] asientosLibresYOcupados;

    public SalaDeConcierto(int tamanioSala){
        this.asientosLibresYOcupados = new boolean[tamanioSala];
        this.iniciarAsientos();
    }

    private void iniciarAsientos(){
        Arrays.fill(asientosLibresYOcupados, true);
    }

    public boolean hayAsientosLibres(){
        boolean res = false;
        int i = 0;
        while (res == false &&  i <= asientosLibresYOcupados.length -1){
            if (asientosLibresYOcupados[i] == true)
                res = true;
        }
        return res;
    }

    public synchronized boolean reservar (int nroAsiento) {
        boolean éxito = false;
        if (this.verificarAsientoLibre(nroAsiento)) {
            this.ocuparAsiento(nroAsiento);
            éxito = true;
        }
        return (éxito);
    }

    public boolean verificarAsientoLibre(int nroAsiento){
        return asientosLibresYOcupados[nroAsiento];
    }

    public void ocuparAsiento(int nroAsiento){
        asientosLibresYOcupados[nroAsiento] = false;
    }

    public boolean[] getAsientosLibresYOcupados() {
        return asientosLibresYOcupados;
    }
}
