package TPO.Punto2;

public class Main {
    public static void main(String[] args) {
        Espacio espacio = new Espacio();
        Recipiente recipiente = new Recipiente(5);
        GeneradorDeAtomos generador = new GeneradorDeAtomos(espacio);
        Thread hiloGenerador = new Thread(generador, "+++ Generador de atomos");

        ConsumidorAgua consumidor = new ConsumidorAgua(espacio, recipiente);
        Thread hiloConsumidor = new Thread(consumidor, "--- Consumidor Agua");

        hiloGenerador.start();
        hiloConsumidor.start();
    }
}
