package ProblemasClasicos.Taxistas;

public class Main {
    public static void main(String[] args){
        int cantidadPasajeros = 3;
        Taxi taxi = new Taxi();
        Thread[] pasajeros = new Thread[cantidadPasajeros];
        Taxista taxista = new Taxista(taxi);
        Thread hiloTaxista = new Thread(taxista, "Taxista1");
        //Pasajero pasajero = new Pasajero(taxi);

        for(int i =0; i < cantidadPasajeros; i++){
            Pasajero pasajero = new Pasajero(taxi);
            Thread hiloPasajero = new Thread(pasajero, "Pasajero"+(i+1));
            pasajeros[i] = hiloPasajero;
            hiloPasajero.start();
        }
        hiloTaxista.start();
        //Thread hiloPasajero = new Thread(pasajero, "Pasajero1");
        //hiloPasajero.start();

    }
}
