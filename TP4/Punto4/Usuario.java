package TP4.Punto4;

public class Usuario implements Runnable{
    private char tipo;
    private CentroImpresion centro;

    public Usuario(char ti, CentroImpresion cen){
        this.tipo = ti;
        this.centro = cen;
    }

    public void run(){
        generarTrabajo();
       
    }

    public void generarTrabajo(){
        System.out.println(Thread.currentThread().getName()+" Generando trabajo tipo"+ this.tipo);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" Trabajo generado, yendo a imprimir...");
        imprimirTrabajo(this.tipo);
    }

    public void imprimirTrabajo(char tipo){
        boolean exito = false;
        switch (this.tipo) {
            case 'A':
                this.centro.usarImpresoraA();
                break;
            case 'B':
                this.centro.usarImpresoraB();
                break;
            case 'X':
                while(!exito){
                    if(this.centro.usarImpresoraA()){
                        exito = true;
                    }else{
                        if (this.centro.usarImpresoraB())) {
                        System.out.println(Thread.currentThread().getName()+" Imprimiendo con impresora tipo B");
                        exito = true;
                        }
                    }
                }
                break;
            default:
                break;
        }
    }
}
