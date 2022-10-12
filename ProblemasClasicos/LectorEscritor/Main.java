package ProblemasClasicos.LectorEscritor;

public class Main {
    public static void main(String[] args) {
        Libro harryPotter = new Libro(25);
        Escritor unEscritor = new Escritor(harryPotter, "Escritor1");
        unEscritor.start();

        Thread[] lectores = new Thread[15];
        for(int i = 0; i < lectores.length; i++){
            lectores[i] = new Lector(harryPotter, "Lector"+i);
            lectores[i].start();
        }
    }
}
