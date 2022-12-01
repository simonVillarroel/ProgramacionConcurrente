package TP5.Punto4;

public class VendedorTickets implements Runnable{
    private Tren tren;

    public VendedorTickets(Tren t){
        this.tren = t;
    }

    public void run(){
        while(true){
            try {
                tren.abrirVenta();
                System.out.println(Thread.currentThread().getName()+" abrió la venta de tickets.");
                tren.cerrarVenta();
                System.out.println(Thread.currentThread().getName()+" cerró la venta de tickets.");
                tren.notificarAControl();
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
    }
}