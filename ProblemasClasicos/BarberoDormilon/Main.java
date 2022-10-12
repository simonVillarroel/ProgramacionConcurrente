package ProblemasClasicos.BarberoDormilon;

public class Main{
    public static void main(String[] args) throws InterruptedException{
        Barberia unaBarberia = new Barberia("El Barbero Dormilon");
        Barbero unBarbero = new Barbero("Tony", unaBarberia);

        Thread hiloBarbero = new Thread(unBarbero);
        hiloBarbero.start();
        Thread[] hiloCliente = new Thread[15];

        for(int i = 0; i < hiloCliente.length; i++){
            Cliente unCliente = new Cliente("Cliente"+i, unaBarberia);
            hiloCliente[i] = new Thread(unCliente);
            hiloCliente[i].start();
        }
    }
}
