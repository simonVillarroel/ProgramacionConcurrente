package TP5.Punto4;

public class Main {
    public static void main(String[] args) {
        int cantidadPasajeros = 15;

        Tren tren = new Tren(5);
        Thread[] pasajeros = new Thread[cantidadPasajeros];

        VendedorTickets vendedor = new VendedorTickets(tren);
        Thread hiloVendedor = new Thread(vendedor, "+++ Vendedor de tickets"); 
        ControlTren control = new ControlTren(tren);
        Thread hiloControl = new Thread(control, "--- Control de tren"); 

        //Creacion de los hilos pasajeros
        for(int i=0; i < cantidadPasajeros; i++){
            Pasajero pasajero = new Pasajero(tren);
            Thread hiloPasajero = new Thread(pasajero, "     Pasajero"+(i+1));
            pasajeros[i] = hiloPasajero;
            hiloPasajero.start();
        }
        hiloVendedor.start();
        hiloControl.start();
    }
}
