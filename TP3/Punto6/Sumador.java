package TP3.Punto6;

public class Sumador implements Runnable{
	private int desde;
	private int hasta;
	private Arreglo arregloRun;
	
	public Sumador(Arreglo arregloTest, int indiceDesde, int indiceHasta) {
		
		this.desde=indiceDesde;
		this.hasta=indiceHasta;
		this.arregloRun=arregloTest;
	}
	
	public void run() {
		int subSuma=0;
		for (int i=desde;i<=hasta;i++) {
			this.arregloRun.sumarItemArreglo(i);
			subSuma=subSuma+arregloRun.getArreglo()[i];
		}
		
		System.out.println("Subtotal "+Thread.currentThread().getName()+" "+subSuma);
	}
}
