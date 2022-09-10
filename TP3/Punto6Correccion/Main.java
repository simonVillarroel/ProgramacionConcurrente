package TP3.Punto3Correccion;

public class Main {
    public static void main(String[] args) {
        int sumaSecuencial=0, indice = 0;
        int cantidadHilos = 7;  //Modificar para probar con diferente cantidad de hilos
        Suma suma = new Suma();
		Arreglo arreglo=new Arreglo(50000);
		arreglo.llenarArreglo();

        Thread[] arregloHilos=new Thread[cantidadHilos];
        int fraccion= arreglo.getArreglo().length/cantidadHilos;
        int resto = 50000 % cantidadHilos; //Se obtiene el resto con la operacion MOD
		
        //Se crean los primeros hilos y se les asignan sus porciones del arreglo
		for (int d=0;d<cantidadHilos-1;d++) {	
			Sumador hiloRun= new Sumador(arreglo, suma, indice, indice+fraccion-1);
			Thread hilo= new Thread(hiloRun,"Hilo "+(d+1));
			hilo.start();
			arregloHilos[d]=hilo;
			//Sout para mostrar los indices de los hilos
			System.out.println("Hilo "+(d+1)+ ". Desde: "+indice+ ". Hasta: " +(indice+fraccion-1));
			indice += fraccion;
		}
        //El ultimo arreglo se le asigna su porcion correspondiente mas el resto de posiciones que
        //hayan sobrado.
        Sumador hiloRun= new Sumador(arreglo, suma, indice, indice+fraccion - 1 + resto);
		Thread hilo= new Thread(hiloRun,"Hilo "+(cantidadHilos));
		hilo.start();
		arregloHilos[cantidadHilos-1] = hilo;
		//Sout para mostrar el indice del ultimo hilo
		System.out.println("Hilo "+cantidadHilos+ ". Desde: "+indice+ ". Hasta: " +(indice+fraccion-1+resto));

        //Se realiza la suma secuencial a la par de los demas hilos
        sumaSecuencial = sumaSecuencial(arreglo);
		
        try {		
			for (int d=0;d<cantidadHilos;d++) 	
				arregloHilos[d].join();				
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}

        System.out.println("---Suma Secuencial: "+sumaSecuencial);
		System.out.println("---Suma Total Hilos: "+ suma.getSumaTotal());
	}

    public static int sumaSecuencial(Arreglo arreglo){
        int suma = 0;
		for (int i=0; i<=arreglo.getArreglo().length-1;i++) {
			suma += arreglo.getArreglo()[i];
		}
        return suma;
    }
}