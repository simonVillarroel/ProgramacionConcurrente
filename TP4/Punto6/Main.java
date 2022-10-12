package TP4.Punto6;

public class Main {
    public static void main(String[] args){
        int cantidadEmpleados = 3;
        Confiteria confiteria = new Confiteria();
        Thread[] empleados = new Thread[cantidadEmpleados];
        Mozo mozo = new Mozo(confiteria);
        Thread hiloMozo = new Thread(mozo, "Mozo");

        for(int i =0; i < cantidadEmpleados; i++){
            Empleado empleado = new Empleado(confiteria);
            Thread hiloEmpleado = new Thread(empleado, "Empleado"+(i+1));
            empleados[i] = hiloEmpleado;
            hiloEmpleado.start();
        }
        hiloMozo.start();
    }
}
