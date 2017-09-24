package heap;

public class App {

    public static void main(String[] args) {

        Heap<Integer> maxHeap = new MaxHeap(10);

        maxHeap.inserir(1);
        maxHeap.inserir(3);
        maxHeap.inserir(4);
        maxHeap.inserir(2);
        maxHeap.inserir(6);
        maxHeap.inserir(7);
        maxHeap.inserir(0);

        maxHeap.imprimir();

        System.out.println();

        System.out.println();

        maxHeap.imprimirIdentado();

    }


}
