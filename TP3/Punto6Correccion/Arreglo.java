package TP3.Punto3Correccion;

import java.util.Random;

public class Arreglo {
	private int[] arreglo;
	
	public Arreglo(int tamanio) {
		arreglo=new int[tamanio];
	}
	
	public int[] getArreglo() {
		return this.arreglo;
	}
	
	public void llenarArreglo() {
		Random randon=new Random();
				
		for (int i=0; i<=this.arreglo.length-1;i++) {
			this.arreglo[i]=randon.nextInt(10)+1;
		}
	}
}
