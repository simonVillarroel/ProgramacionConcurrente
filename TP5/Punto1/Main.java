package TP5.Punto1;

public class Main {
    public static void main(String[] args){
        int cantidadEmpleados = 5;
        Confiteria confiteria = new Confiteria();
        Thread[] empleados = new Thread[cantidadEmpleados];
        Mozo mozo = new Mozo(confiteria);
        Thread hiloMozo = new Thread(mozo, "Mozo");

        Cocinero cocinero = new Cocinero(confiteria);
        Thread hiloCocinero = new Thread(cocinero, "Cocinero");

        //Creacion de los hilos empleados
        for(int i =0; i < cantidadEmpleados; i++){
            Empleado empleado = new Empleado(confiteria);
            Thread hiloEmpleado = new Thread(empleado, "Empleado"+(i+1));
            empleados[i] = hiloEmpleado;
            hiloEmpleado.start();
        }
        hiloMozo.start();
        hiloCocinero.start();
    }
}
