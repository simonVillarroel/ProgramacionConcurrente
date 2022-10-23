package TPO.Punto1;

import java.util.concurrent.Semaphore;

public class Transbordador{
    private int espaciosOcupados, espacioTotal;
    private Semaphore subir, bajar, viaje, abrirCompuerta;

    public Transbordador(int espacios){
        this.espaciosOcupados = 0;
        this.espacioTotal = espacios;
        this.subir = new Semaphore(0);
        this.bajar = new Semaphore(0);
        this.viaje = new Semaphore(0);
        this.abrirCompuerta = new Semaphore(1);
    }

    //Metodos de clase Auto 
    public void subir() throws InterruptedException{
        this.subir.acquire();
        this.espaciosOcupados++;
    }

    public void puedeSubir(){ //Avisa al siguiente auto que puede subir
        if(this.espaciosOcupados == this.espacioTotal){
            this.viaje.release();
        }else{
            this.subir.release();
        }
    }

    public void bajar() throws InterruptedException{
        this.bajar.acquire();
        this.espaciosOcupados--;    
    }

    public void puedeBajar(){ //Avisa al siguiente auto que puede bajar
        if(this.espaciosOcupados == 0){
            this.viaje.release();
        }else{
            this.bajar.release();
        }
    }

    //Metodos de clase ControlTransbordador
    public void liberarEntrada() throws InterruptedException{
        this.abrirCompuerta.acquire();
        System.out.println("Entrada liberada.");
        this.subir.release();
    }

    public void comenzarViaje() throws InterruptedException{
        this.viaje.acquire();
        System.out.println("El viaje comenzo.");
    }

    public void llegoOeste(){
        System.out.println("Llego al destino Oeste.");
        this.abrirCompuerta.release();
    }

    public void liberarSalida() throws InterruptedException{
        this.abrirCompuerta.acquire();
        System.out.println("Salida liberada.");
        this.bajar.release();
    }

    public void llegoEste(){
        System.out.println("Llego al destino Este.");
        this.abrirCompuerta.release();
    }
}