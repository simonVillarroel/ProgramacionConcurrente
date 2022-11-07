package TP6.Punto2;

public class GestorSala {
    private int temperatura, tUmbral, personasDentro, jubiladosEsperando, capacidadPersonas;

    public GestorSala(){
        this.tUmbral = 30;
        this.temperatura = 0;
        this.personasDentro = 0;
        this.jubiladosEsperando = 0;
        this.capacidadPersonas = 0;
    }

    //Metodos clase persona
    public synchronized void entrarSala(){
        while(salaLlena() && jubiladosEsperando > 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.personasDentro++;
        System.out.println("Personas dentro: "+personasDentro);
    }

    public synchronized void esperarJubilado(){
        this.jubiladosEsperando++;
        System.out.println("Jubilados esperando: "+jubiladosEsperando);
    }

    public synchronized void entrarSalaJubilado(){
        while(salaLlena()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.jubiladosEsperando--;
        System.out.println("Jubilados esperando: "+jubiladosEsperando);
        this.personasDentro++;
        System.out.println("Personas dentro: "+personasDentro);
    }

    public synchronized void salirSala(){
        this.personasDentro--;
        System.out.println("Personas dentro: "+personasDentro);
        this.notifyAll();
    }
    public boolean salaLlena(){
        return personasDentro >= capacidadPersonas;
    }

    //Metodos clase ControlTemperatura
    public void notificarTemperatura(int medicion){
        this.temperatura = medicion;
        if(temperatura > tUmbral){
            this.capacidadPersonas = 5;
        }else{
            this.capacidadPersonas = 10;
        }
        System.out.println("    Temperatura actual "+medicion+" grados. Capacidad de personas: "+this.capacidadPersonas);
    }
}
