package TP3.Punto5;

public class Main {
    public static void main(String[] args) {
        Thread[] arregloAutos = new Thread[5];
        Surtidor surtidor = new Surtidor(500);
        
        //Creacion arreglo de autos
        for (int i=0; i<arregloAutos.length; i++) {	
			Auto runAuto= new Auto("000"+i, "Modelo", "Marca", 00000, 70, surtidor);
			Thread hiloAuto = new Thread(runAuto);
            hiloAuto.start();
			arregloAutos[i]= hiloAuto;
		}
    }
}
