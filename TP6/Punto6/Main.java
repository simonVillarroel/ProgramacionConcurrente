package TP6.Punto6;

public class Main {
    public static void main(String[] args) {
        int cantidadPacientes = 100;
        CentroHemoterapia centro = new CentroHemoterapia();
        
        //Creacion de los hilos Persona
        for(int i =0; i < cantidadPacientes; i++){
            Paciente paciente= new Paciente(centro);
            Thread hiloPaciente = new Thread(paciente, "Paciente"+i);
            hiloPaciente.start();
        }
    }
}
