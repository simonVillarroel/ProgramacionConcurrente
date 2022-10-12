package ProblemasClasicos.ProductorConsumidor;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Productor runProductor = new Productor(buffer);
        Thread hiloProductor = new Thread(runProductor, "Productor1");
        hiloProductor.start();

        Thread[] consumidores = new Thread[50];
        for(int i = 0; i < consumidores.length; i++){
            Consumidor runConsumidor = new Consumidor(buffer);
            Thread hiloConsumidor = new Thread(runConsumidor, "Consumidor"+i);
            consumidores[i] = hiloConsumidor;
            hiloConsumidor.start();
        }
    }
}
