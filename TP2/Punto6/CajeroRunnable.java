package TP2.Punto6;

public class CajeroRunnable implements Runnable{
    private String nombre;
    private Cliente cliente;
    private long initialTime;
    
    public CajeroRunnable(String nom, Cliente cli, long time){
        this.nombre = nom;
        this.cliente = cli;
        this.initialTime = time;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getInitialTime() {
        return initialTime;
    }
    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }

    public void run() {
        System.out.println("El cajero " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
            + this.cliente.getNombre() + " EN EL TIEMPO: "
            + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) 
                + " del cliente " + this.cliente.getNombre() + "->Tiempo: " +
                (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        }
        System.out.println("El cajero" + this.nombre + " HA TERMINADO DE PROCESAR "
            + this.cliente.getNombre() + " EN EL TIEMPO: " +
            (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
    }

    public void esperarXsegundos(int productoCarro){
        try {
            Thread.sleep(productoCarro*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
