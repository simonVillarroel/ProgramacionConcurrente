package ProblemasClasicos.LectorEscritor;

public class Escritor extends Thread{
    private Libro libro;
    private String nombre;

    public Escritor(Libro l, String n){
        this.libro = l;
        this.nombre = n;
    }

    public void run(){
        while(!libro.finalizado()){
            libro.empezarEscribir();
            System.out.println("+++"+this.nombre+" escribiendo...");
            escribir();
            System.out.println("+++"+this.nombre+" agrego una pagina al libro");
            libro.terminarEscribir();
        }
    }

    public void escribir(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
