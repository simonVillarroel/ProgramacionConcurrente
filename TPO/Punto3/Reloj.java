package TPO.Punto3;

public class Reloj {
    private int hora, horaTotal, cantidadDurmientes, totalDurmientes;

    public Reloj(int total){
        this.hora = 0;
        this.horaTotal = 24;
        this.cantidadDurmientes = total;
        this.totalDurmientes = total;
    }

    //Metodos de Durmiente
    public int getHora() {
        return hora;
    }
    public synchronized void incrementarTotalDurmientes(){
        this.totalDurmientes++;
    }
    public synchronized void decrementarTotalDurmientes(){
        this.totalDurmientes--;
    }

    public synchronized void trabajar(int horaComienzoTrabajo){
        while(horaComienzoTrabajo != this.hora){
            System.out.println("+++ "+Thread.currentThread().getName()+": No es mi horario de trabajo.");
            try {
                this.wait();
                if(this.cantidadDurmientes > 0){
                    this.notify();
                    cantidadDurmientes--;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //Metodos de ControlReloj
    public synchronized void incrementarHora(){
        if(this.hora+1 == this.horaTotal){
            this.hora = 0;
        }else{
            this.hora++;
        }
        cantidadDurmientes = totalDurmientes-1;
        this.notify();
        System.out.println();
        System.out.println("///// Hora actual "+ this.hora+"hs. /////");
    }
}
