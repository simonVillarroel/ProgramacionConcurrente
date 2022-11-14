package ProblemasClasicos.CenaDeFilosofos;

public class Main {
    public static void main(String[] args) {
        Mesa mesa = new Mesa();
        int izquierdo = 0, derecho = 4;

        for(int i = 0; i < 5; i++){
            Filosofo filosofo = new Filosofo(mesa, izquierdo, derecho);
            Thread hiloFilosofo = new Thread(filosofo, "Filosofo"+i);
            hiloFilosofo.start();
            if(izquierdo == 4){
                izquierdo = 0;
            }else{
                izquierdo++;
            }
            if(derecho == 4){
                derecho = 0;
            }else{
                derecho++;
            }
        }
    }
}
//Diagrama de la mesa
//          (F0)
//     t4          t0
//(F4)                (F1)
//   t3              t1
//      (F3)    (F2)
//           t2