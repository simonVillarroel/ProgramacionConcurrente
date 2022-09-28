package TP3.Punto3;

public class Main {
    public static void main(String[] args) {
        Thread[] arregloEncargados = new Thread[5];
        SalaDeConcierto sala = new SalaDeConcierto(30);
        
        //Creacion arreglo de encargados
        for (int i=0; i<arregloEncargados.length; i++) {	
			EmpleadoTerminal runEncargado= new EmpleadoTerminal(sala);
			Thread hiloEncargado = new Thread(runEncargado, "Encargado"+(i+1));
            hiloEncargado.start();
			arregloEncargados[i]= hiloEncargado;
		}
    }
}
