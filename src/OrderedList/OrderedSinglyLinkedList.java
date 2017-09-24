package OrderedList;

public class OrderedSinglyLinkedList<T extends Integer> implements List<T> {

    private Node<T> list;
    private Node<T> last;


    public OrderedSinglyLinkedList() {
        this.list = null;
    }

    @Override
    public void add(T obj) {

        Node<T> aux;
        Node<T> before = null;
        Node<T> node = new Node<>(obj);

        // se a lista está vazia
        if (list == null) {
            list = node;
            last = node;
        } else {
            // a lista já contém elementos e o novo elemento será inserido
            // na lista respeitando a ordenação crescente
            aux = list;
            while (aux != null &&
                    node.getValue().intValue() > aux.getValue().intValue()) {
                before = aux;
                aux = aux.getNext();
            }
            // Se o numero a ser inserido é menor que todos os numeros da lista
            // será inserido no inicio da lista
            if (before == null) {
                node.setNext(list);
                list = node;
            } else if (aux == null) {
                //se o número a ser inserido é maior que todos os números da lista
                // será inserido no final
                last.setNext(node);
                last = node;
            } else {
                // se o novo número a ser inserido será inserido entre dois números
                //que já estão na lista
                before.setNext(node);
                node.setNext(aux);
            }
        }
    }

    @Override
    public void set(int position, T obj) {

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
        }
    }

    @Override
    public void remove(T obj) {

        Node<T> before;
        Node<T> aux;

        // se a lista estiver vazia
        if (list == null) {
            return;
        } else {
            aux = list;
            before = null;
            while (aux != null) {
                // se o número a ser removido for encontrado
                if (aux.getValue().equals(obj)) {
                    // se o número a ser removido é o primeiro da lista
                    if (aux == list) {
                        list = aux.getNext();
                        aux = list;
                        // se o número a ser removido é o último da lista
                    } else if (aux == last) {
                        last = null;
                        aux = null;
                        // se o número a ser removido está no meio da lista
                    } else {
                        before.setNext(aux.getNext());
                        aux = aux.getNext();
                    }
                } else {
                    before = aux;
                    aux = aux.getNext();
                }
            }
        }
    }

    @Override
    public void remove(int position) {

        int count = 0;
        Node<T> aux = list;
        Node<T> before = null;

        if (position == 0) {
            list = list.getNext();
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
    public T get(int position) {

        int count = 0;
        Node<T> node = list;

        if (list == null) {
            System.out.println("Lisa Vazia!");
        } else {
            while (count < position) {
                node = node.getNext();
                count++;
            }
        }
        return node.getValue();
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

        while (node.getNext() != null) {
            if (node.getValue().equals(obj))
                break;
            node = node.getNext();
        }
        return node.getValue().equals(obj);
    }
}
