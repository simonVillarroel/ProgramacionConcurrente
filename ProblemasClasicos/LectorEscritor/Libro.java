package ProblemasClasicos.LectorEscritor;

import java.util.concurrent.Semaphore;

public class Libro {
    private int nLectores, nEscritores;
    private int paginasEscritas;
    private int totalPaginas;
    private Semaphore mutex1, mutex2, lectores, escritores;

    public Libro(int total){
        this.nLectores = 0;
        this.nEscritores = 0;
        this.paginasEscritas = 0;
        this.totalPaginas = total;
        this.mutex1 = new Semaphore(1);
        this.mutex2 = new Semaphore(1);
        this.lectores = new Semaphore(1);
        this.escritores = new Semaphore(1);
    }

    //Metodos Lector
    public void empezarLeer(){
        try {
            lectores.acquire();
            mutex1.acquire();
            nLectores++;
            if(nLectores==1){
                escritores.acquire();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mutex1.release();
        lectores.release();
    }

    public void terminarLeer(){
        try {
            mutex1.acquire();
            nLectores--;
            if (nLectores == 0) {
                escritores.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mutex1.release();
    }

    //Metodos Escritor
    public void empezarEscribir(){
        try {
            mutex2.acquire();
            nEscritores++;
            if(nEscritores == 1){
                lectores.acquire();
            }
            mutex2.release();
            escritores.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void terminarEscribir(){
        escritores.release();
        try {
            mutex2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nEscritores--;
        if(nEscritores == 0){
            lectores.release();
        }
        paginasEscritas++;
        mutex2.release();
    }

    public boolean finalizado(){
        return paginasEscritas == totalPaginas;
    }

    public boolean hayEscrito(){
        return paginasEscritas > 0;
    }
}
