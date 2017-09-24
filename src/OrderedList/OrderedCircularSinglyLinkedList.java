package OrderedList;

public class OrderedCircularSinglyLinkedList<T extends Number> implements List<T> {

    private Node<T> list;
    private Node<T> last;

    public OrderedCircularSinglyLinkedList() {
        this.list = null;
        this.last = null;
    }

    @Override
    public void add(T obj) {

        Node<T> node = new Node<>(obj);

        // se a lista estiver vazia
        if (list == null) {
            list = node;
            node.setNext(list);
            last = list;
        } else {

            // a lista já contém elementos e o novo
            // elemento será inserido na lista
            // respeitando a ordenação crescente

            Node<T> aux = list;
            Node<T> before = null;

            // Se a lista só tem um nó
            if (list == last) {

                // se o novo número é menor que o primeiro número da lista
                // adiciona no inicio da lista

                if (node.getValue().intValue() < aux.getValue().intValue()) {
                    node.setNext(list);
                    list.setNext(node);
                    list = node;

                    // se o novo número é maior do que o primeiro número da lista
                    // adiciona no final da lista

                } else {
                    last.setNext(node);
                    node.setNext(list);
                    last = node;
                }

                // se a lista tem mais de dois elementos
            } else {


                // pecorre a lista
                while (aux != last && node.getValue().intValue() > aux.getValue().intValue()) {
                    before = aux;
                    aux = aux.getNext();
                }

                // adiciona no incio da lista se o número é menor que o primeiro número da lista
                if (before == null) {
                    node.setNext(list);
                    last.setNext(node);
                    list = node;

                    //adiciona no final da lista
                } else if (aux == last && node.getValue().intValue() > aux.getValue().intValue()) {
                    last.setNext(node);
                    node.setNext(list);
                    last = node;

                    //adicion entre dois nós
                } else {
                    before.setNext(node);
                    node.setNext(aux);
                }
            }
        }
    }

    @Override
    public void set ( int position, T obj){
        int count = 0;
        Node<T> aux = list;

        if (position == 0) {
            aux.setValue(obj);
        } else {
            while (count < position) {
                aux = aux.getNext();
                count++;
            }
            aux.setValue(obj);
            System.out.printf("");
        }
    }

    @Override
    public void remove (T obj){
        if (list == null) {
            System.out.println("Lista Vazia!");
        } else {
            Node<T> before = null;
            Node<T> aux = list;

            while (before != last) {

                if (aux.getValue().equals(obj)) {

                    if (aux == list) {
                        list = aux.getNext();
                        last.setNext(list);
                        aux.setNext(null);
                        before = last; // sai do loop
                    } else if (aux == last) {
                        last.setNext(null);
                        last = before;
                        last.setNext(list);
                        before = last; // sai do loop
                    } else {
                        before.setNext(aux.getNext());
                        aux.setNext(null);
                        before = last; // sai do loop
                    }
                } else {
                    before = aux;
                    aux = aux.getNext();
                }
            }
        }
    }

    @Override
    public void remove ( int position){
        int count = 0;
        Node<T> aux = list;
        Node<T> before = null;

        if (position == 0) {
            list = aux.getNext();
            last.setNext(list);
            aux.setNext(null);
        } else {
            while (count < position) {
                before = aux;
                aux = aux.getNext();
                count++;
            }
            before.setNext(aux.getNext());
            aux.setNext(null);
        }
    }

    @Override
    public T get ( int position){
        int count = 0;
        Node<T> node = list;

        if (list == null) {
            System.out.println("Vazia!");
        } else {
            while (count < position) {
                node = node.getNext();
                count++;
            }
        }
        return node.getValue();
    }

    @Override
    public T first () {
        return list.getValue();
    }

    @Override
    public T last () {
        return last.getValue();
    }

    @Override
    public boolean isEmpty () {
        return list == null;
    }

    @Override
    public boolean contains (T obj){
        Node<T> node = list;

        while (node != last) {
            if (node.getValue().equals(obj))
                break;
            node = node.getNext();
        }
        return node.getValue().equals(obj);
    }

}

