package TP3.Punto6;

import java.util.Random;

public class Arreglo {

	private int suma;
	private int[] arreglo;
	
	public Arreglo(int tamaño) {
		arreglo=new int[tamaño];
	}
	
	public int[] getArreglo() {
		return this.arreglo;
	}

	public int getSuma() {
		return this.suma;
	}

	
	public void llenarArreglo() {
		Random randon=new Random();
				
		for (int i=0; i<=this.arreglo.length-1;i++) {
			this.arreglo[i]=randon.nextInt(10)+1;
		}
	}
	
	public synchronized void sumarItemArreglo(int posicion) {
		
		this.suma=this.suma+arreglo[posicion];		
	}
	
}
