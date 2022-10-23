package TP5.Punto4;

public class VendedorTickets implements Runnable{
    private Tren tren;

    public VendedorTickets(Tren t){
        this.tren = t;
    }

    public void run(){
        while(true){
            //System.out.println(tren.asientosVacios());
            if(tren.asientosVacios()){
                System.out.println(Thread.currentThread().getName()+" abrió la venta de tickets.");
                try {
                    tren.abrirVenta();
                    tren.cerrarVenta();
                    System.out.println(Thread.currentThread().getName()+" cerró la venta de tickets.");
                    tren.notificarAControl();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
}