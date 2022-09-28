package TP3.Punto3;

public class MainArreglo {
	
	public static void main (String[] args) {
		int suma=0;
		int cantidad=50000;
		Arreglo arreglo=new Arreglo(cantidad);
		int fraccion=0;
		
		arreglo.llenarArreglo();
		
		for (int i=0; i<=arreglo.getArreglo().length-1;i++) {
//			System.out.println(i+": " +arreglo.getArreglo()[i]);
			suma=suma+arreglo.getArreglo()[i];
		}

		System.out.println("Imprimir Suma Secuencial: "+suma);
		
		fraccion=cantidad/5;
		
		
		Thread[] arregloHilos=new Thread[5];  
		int z=0;
		
		for (int d=0;d<5;d++) {	
			Sumador hiloRun= new Sumador(arreglo,z,z+fraccion-1);
			Thread hilo= new Thread(hiloRun,"Hilo "+(d+1));
			hilo.start();
			arregloHilos[d]=hilo;
			
			z=z+fraccion;
			
		}
		
//		Sumador hiloRun1= new Sumador(arreglo,0,9999);
//		Sumador hiloRun2= new Sumador(arreglo,10000,19999);
//		Sumador hiloRun3= new Sumador(arreglo,20000,29999);
//		Sumador hiloRun4= new Sumador(arreglo,30000,39999);
//		Sumador hiloRun5= new Sumador(arreglo,40000,49999);
//		
//		Thread hilo1= new Thread(hiloRun1,"Hilo 1");
//		Thread hilo2= new Thread(hiloRun2,"Hilo 2");
//		Thread hilo3= new Thread(hiloRun3,"Hilo 3");
//		Thread hilo4= new Thread(hiloRun4,"Hilo 4");
//		Thread hilo5= new Thread(hiloRun5,"Hilos 5");
//		
//		hilo1.start();
//		hilo2.start();
//		hilo3.start();
//		hilo4.start();
//		hilo5.start();
		
		try {		
			for (int d=0;d<5;d++) 	
				arregloHilos[d].join();				
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Suma Total Hilos: "+ arreglo.getSuma());
	}

}
