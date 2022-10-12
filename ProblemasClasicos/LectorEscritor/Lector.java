package ProblemasClasicos.LectorEscritor;

public class Lector extends Thread{
    private Libro libro;
    private String nombre;

    public Lector(Libro l, String n){
        this.libro = l;
        this.nombre = n;
    }

    public void run(){
        boolean terminaLeer = false;
        while(!terminaLeer){
            if(libro.hayEscrito()){
                libro.empezarLeer();
                System.out.println("---"+this.nombre+" leyendo...");
                leer();
                System.out.println("---"+this.nombre+" termino de leer");
                libro.terminarLeer();
                terminaLeer = true;
            }else{
                esperar();
            }
        }
    }

    public void leer(){
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void esperar(){
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
