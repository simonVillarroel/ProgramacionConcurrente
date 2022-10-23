package TPO.Punto1;

public class Main {
    public static void main(String[] args) {
        int cantidadEspacios = 10, cantidadAutos = 30;

        Transbordador transbordador = new Transbordador(cantidadEspacios);
        Thread[] autos = new Thread[cantidadAutos];

        ControlTransbordador control = new ControlTransbordador(transbordador);
        Thread hiloControl = new Thread(control, "+++ Control del transbordador");
        hiloControl.start();

        //Creacion de los hilos Auto
        for(int i=0; i < cantidadAutos; i++){
            Auto auto = new Auto(transbordador);
            Thread hiloAuto = new Thread(auto, "--- Auto"+(i+1));
            autos[i] = hiloAuto;
            hiloAuto.start();
        }
    }
}
