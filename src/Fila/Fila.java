package Fila;

public class Fila<T> implements List<T> {

    private Node<T> fila;

    public Fila() {

    }

    @Override
    public void add(T obj) {
        Node<T> node = new Node<>(obj);

        if (fila == null) {
            fila = node;
        } else {
            node.setNext(fila);
            fila = node;
        }
    }

    @Override
    public void remove() {

        Node<T> node = fila;
        Node<T> aux = node;

        // se a fila estiver vazia
        if (fila == null) {
            System.out.println("Lista Vazia!");
            // se a fila tiver apenas um nó
        } else if (fila.getNext() == null) {
            fila = null;
            // mais de um nó
        } else {
            while (node.getNext() != null) {
                aux = node;
                node = node.getNext();
            }
            aux.setNext(null);
        }
    }

    @Override
    public void imprimir() {

        Node<T> node = fila;

        while (node != null) {
            System.out.printf("%d ", node.getValue());
            node = node.getNext();
        }

    }
}

