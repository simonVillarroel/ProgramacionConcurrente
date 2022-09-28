package TP3.Punto7;

public class Turno {
    private int turno;

    public Turno(){
        this.turno = 'A';
    }

    public synchronized void siguiente(char letra){
        switch (letra) {
            case 'A':
                this.turno = 'B';
                break;
            case 'B':
                this.turno = 'C';
                break;
            case 'C':
                this.turno = 'A';
                break;
            default:
                break;
        }
    }

    public synchronized int getTurno() {
        return turno;
    }
}
