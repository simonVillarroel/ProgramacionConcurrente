package TP5.Punto7;

import java.util.concurrent.Semaphore;

public class Cuerda {
    private int capacidad, cruzando, esperandoLadoA, esperandoLadoB;
    private Semaphore cruceLadoA, cruceLadoB, mutex;

    public Cuerda(){
        this.capacidad = 5;
        this.esperandoLadoA = 0;
        this.esperandoLadoB = 0;
        this.cruceLadoA = new Semaphore(0);
        this.cruceLadoB = new Semaphore(0);
        this.mutex = new Semaphore(1);
        this.cruzando = 0;
    }

    public void esperar(char lado) throws InterruptedException {
        this.mutex.acquire();
        inicializarTurno(lado);
        if(lado == 'A'){
            this.esperandoLadoA++;
            System.out.println("Esperando lado A: "+this.esperandoLadoA);
        }else{
            this.esperandoLadoB++;
            System.out.println("Esperando lado B: "+this.esperandoLadoB);
        }
        this.mutex.release();
    }

    private void inicializarTurno(char lado){
        //Inicializa el turno solo el primer hilo que llama al metodo 
        if(this.esperandoLadoA == 0 && this.esperandoLadoB == 0){ 
            if(lado == 'A'){
                this.cruceLadoA.release(this.capacidad);
            }else{
                this.cruceLadoB.release(this.capacidad);
            }
        }
    }
    public void cruzar(char lado) throws InterruptedException{
        if(lado == 'A'){
            this.cruceLadoA.acquire();
        }else{
            this.cruceLadoB.acquire();
        }
        this.mutex.acquire();
        this.cruzando++;
        this.mutex.release();
    }

    public void terminarCruce(char lado) throws InterruptedException{
        this.mutex.acquire();
        this.cruzando--;
        this.mutex.release();
        if(this.cruzando == 0){
            cambiarTurno(lado);
        }
    }

    private void cambiarTurno(char lado){
        if(lado == 'A'){
            if(this.esperandoLadoB > 0){
                this.cruceLadoB.release(5);
            }else{
                this.cruceLadoA.release(5);
            }
        }
        if(lado == 'B'){
            if(this.esperandoLadoA > 0){
                this.cruceLadoA.release(5);
            }else{
                this.cruceLadoB.release(5);
            }
        }
    }

    
}
