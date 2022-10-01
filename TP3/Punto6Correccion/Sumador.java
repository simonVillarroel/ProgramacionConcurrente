package TP3.Punto6Correccion;

public class Sumador implements Runnable{
    private int desde;
	private int hasta;
	private Arreglo arreglo;
    private Suma suma;
	
	public Sumador(Arreglo arr, Suma sum, int indiceDesde, int indiceHasta) {
        this.suma = sum;
        this.arreglo=arr;
        this.desde=indiceDesde;
		this.hasta=indiceHasta;
	}
	
	public void run() {
		int subSuma=0;
		for (int i=desde;i<=hasta;i++) {
			subSuma=subSuma+arreglo.getArreglo()[i];
		}
		//Se suma el subtotal de cada hilo a la suma total, en vez de cada posicion del arreglo
		//ahorrando accesos al metodo incrementar()
		this.suma.incrementar(subSuma);
		System.out.println("Subtotal "+Thread.currentThread().getName()+" "+subSuma);
	}
}
