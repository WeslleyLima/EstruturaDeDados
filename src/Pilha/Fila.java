package Pilha;

public class Fila<T> implements List<T> {

    private Node<T> pilha;

    @Override
    public void add(T obj) {
        Node<T> node = new Node<>(obj);

        if (pilha == null) {
            pilha = node;
        } else {
            node.setNext(pilha);
            pilha = node;
        }
    }

    @Override
    public void remove() {
        Node<T> aux = pilha;

        if (pilha == null) {
            System.out.println("Pilha Vazia");
        } else {
            pilha = pilha.getNext();
            aux.setValue(null);
        }
    }

    @Override
    public void imprimir() {
        Node<T> node = pilha;

        while (node != null) {
            System.out.printf("%d ", node.getValue());
            node = node.getNext();
        }
    }
}
