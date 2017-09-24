package OrderedList;

public class OrderedCircularDoublyLinkedList<T extends Number> implements List<T> {

    private Node<T> list;
    private Node<T> last;

    public OrderedCircularDoublyLinkedList() {
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
            node.setPrivious(list);
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
                    node.setPrivious(list);
                    list.setNext(node);
                    list.setPrivious(node);
                    list = node;

                    // se o novo número é maior do que o primeiro número da lista
                    // adiciona no final da lista

                } else {
                    last.setNext(node);
                    last.setPrivious(node);
                    node.setNext(last);
                    node.setPrivious(last);
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
                    node.setPrivious(last);
                    list.setPrivious(node);
                    list = node;

                    //adiciona no final da lista
                } else if (aux == last && node.getValue().intValue() > aux.getValue().intValue()) {
                    last.setNext(node);
                    last.setPrivious(node);
                    node.setNext(last);
                    node.setPrivious(last);
                    last = node;

                    //adicion entre dois nós
                } else {
                    before.setNext(node);
                    aux.setPrivious(node);
                    node.setNext(aux);
                    node.setPrivious(before);
                }
            }
        }
    }

    @Override
    public void set(int position, T obj) {
        int count = 0;
        Node<T> node = list;

        while (count < position) {
            node = node.getNext();
            count++;
        }
        node.setValue(obj);
    }

    @Override
    public void remove(T obj) {

        Node<T> node = list;

        // se o obj estiver no primeiro nó
        if (node.getValue().equals(obj)) {
            list = list.getNext();
            node.setNext(null);
            node.setPrivious(null);
            list.setPrivious(last);
            last.setNext(list);

        } else {
            // variavel aponta para o segundo nó
            node = node.getNext();

            while (node != last) {
                if (node.getValue().equals(obj))
                    break;
                node = node.getNext();
            }

            node.getPrivious().setNext(node.getNext());
            node.getNext().setPrivious(node.getPrivious());

            if (node == last)
                last = node.getPrivious();

            node.setPrivious(null);
            node.setNext(null);

        }
    }

    @Override
    public void remove(int position) {
        int count = 0;
        Node<T> aux = list;

        if (position == 0) {
            list = aux.getNext();
            aux.setPrivious(null);
            aux.setNext(null);
            list.setPrivious(last);
            last.setNext(list);
        } else {

            while (count < position) {
                aux = aux.getNext();
                count++;
            }

            aux.getPrivious().setNext(aux.getNext());
            aux.getNext().setPrivious(aux.getPrivious());

            if (aux == last)
                last = aux.getPrivious();

            aux.setNext(null);
            aux.setPrivious(null);
        }
    }

    @Override
    public T get(int position) {
        int count = 0;
        Node<T> aux = list;
        if (list == null) {
            System.out.println("List Vazia!");
        } else {
            while (count < position) {
                aux = aux.getNext();
                count++;
            }
        }
        return aux.getValue();
    }

    @Override
    public T first() {
        return list.getValue();
    }

    @Override
    public T last() {
        return last.getValue();
    }

    @Override
    public boolean isEmpty() {
        return list == null;
    }

    @Override
    public boolean contains(T obj) {

        Node<T> node = list;

        while (node != last) {
            if (node.getValue().equals(obj))
                break;
            node = node.getNext();
        }

        return node.getValue().equals(obj);
    }
}
