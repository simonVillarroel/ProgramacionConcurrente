package TP4.Punto4;

public class Main {
    public static void main(String[] args) {
        Thread[] arregloUsuariosA = new Thread[5];
        Thread[] arregloUsuariosB= new Thread[5];
        Thread[] arregloUsuariosX = new Thread[5];
        CentroImpresion centro = new CentroImpresion();
        
        //Creacion arreglo de autos
        for (int i=0; i<arregloUsuariosA.length; i++) {	
			Usuario runUsuario= new Usuario('A', centro);
			Thread hiloUsuario = new Thread(runUsuario, "UsuarioA"+i);
            hiloUsuario.start();
			arregloUsuariosA[i]= hiloUsuario;
		}
        for (int i=0; i<arregloUsuariosB.length; i++) {	
			Usuario runUsuario= new Usuario('B', centro);
			Thread hiloUsuario = new Thread(runUsuario, "UsuarioB"+i);
            hiloUsuario.start();
			arregloUsuariosB[i]= hiloUsuario;
		}
        for (int i=0; i<arregloUsuariosX.length; i++) {	
			Usuario runUsuario= new Usuario('X', centro);
			Thread hiloUsuario = new Thread(runUsuario, "UsuarioX"+i);
            hiloUsuario.start();
			arregloUsuariosX[i]= hiloUsuario;
		}
    }
}
