package Pilha;

public class AppPilha {

    public static void main(String[] args) {

        List<Integer> pilha = new Fila<Integer>();


        pilha.imprimir();

        pilha.remove();

        System.out.println();

        pilha.imprimir();
    }

}