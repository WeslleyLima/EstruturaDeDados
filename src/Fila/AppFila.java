package Fila;

public class AppFila {

    public static void main(String[] args) {

        List<Integer> fila = new Fila<Integer>();

        fila.add(0);
        fila.add(1);
        fila.add(2);
        fila.add(3);

        fila.imprimir();

        fila.remove();
        fila.remove();
        fila.remove();
        fila.remove();
        fila.remove();
        System.out.println();

        fila.imprimir();
    }
}
