package OrderedList;

public class OrderedDoubleLinkedList<T extends Number> implements List<T> {

    private Node<T> list;
    private Node<T> last;

    public OrderedDoubleLinkedList() {
        this.list = null;
        this.list = null;
    }

    @Override
    public void add(T obj) {

        Node<T> node = new Node<>(obj);
        // se a lista  está vazia
        if (list == null) {
            list = node;
            last = node;
        }

        // se a lista já contém elementos e o novo elemento
        // será inserido na lista respeitando a ordenação
        // crescente
        else {

            Node<T> aux = list;

            // percorre a lista até o final comparando
            // os valores do novo nó com os valores
            // encontrados nos nós percorridos
            while (aux != null && node.getValue().intValue() > aux.getValue().intValue())
                aux = aux.getNext();

            // se número inserido é menos que todos os números
            // da lista será inserido no início da lista
            if (aux == list) {
                node.setNext(list);
                list.setPrivious(node);
                list = node;
            }

            // se o número a ser inserido é maior que todos os
            // números da lista e será inserido no final
            else if (aux == null) {
                last.setNext(node);
                node.setPrivious(last);
                last = node;
            }

            // se o novo número a ser inserido será inserido
            // entre dois números que já estão na lista
            else {
                node.setNext(aux);
                aux.getPrivious().setNext(node);
                node.setPrivious(aux.getPrivious());
                aux.setPrivious(node);
            }
        }
    }

    @Override
    public void set(int position, T obj) {

        int count = 0;
        Node<T>  aux = list;

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
        // se a lista estiver vazia
        if (list == null) {
            System.out.println("Lista Vazia!");
        } else {
            Node<T> aux = list;

            while (aux != null) {

                // se o número a ser removido for encontrado
                if (aux.getValue().equals(obj)) {

                    //se o número for o primeiro da lista
                    if (aux == list) {

                        list = aux.getNext();

                        // a lista tiver mais de um número
                        if (list != null) {
                            list.setPrivious(null);
                        }

                        aux.setNext(null);
                        aux = null;
                    }

                    // se o número a ser removido é o ultimo da lista
                    else if (aux == last) {
                        last = last.getPrivious();
                        last.setNext(null);
                        aux.setPrivious(null);
                        aux = null;
                    }

                    // se o número a ser removido está no meio da lista
                    else {
                       aux.getPrivious().setNext(aux.getNext());
                       aux.getNext().setPrivious(aux.getPrivious());
                       aux.setPrivious(null);
                       aux.setNext(null);
                       aux = null;
                    }
                }

                // se o número a ser removido não for encontrado
                else {
                    aux = aux.getNext();
                }
            }
        }
    }

    @Override
    public void remove(int position) {

        int count = 0;
        Node<T> aux = list;

        if (position == 0) {
            list = list.getNext();
            // se a lista tiver mais de um nó
            if (list != null)
                list.setPrivious(null);
            aux.setNext(null);
        } else {

            while (count < position) {
                aux = aux.getNext();
                count++;
            }

            aux.getPrivious().setNext(aux.getNext());

            if (aux.getNext() != null)
                aux.getNext().setPrivious(aux.getPrivious());

            aux.setPrivious(null);
            aux.setNext(null);
        }
    }

    @Override
    public T get(int position) {
        int count = 0;
        Node<T> aux = list;
        if (list == null) {
            System.out.println("Lista Vazia!");
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

        // percorre a lista até o ultimo elemento + 1;
        while (node != null) {
            // se achar o número no primeiro nó
            if (node.getValue().equals(obj))
                break;
            node =  node.getNext();
        }

        // não achou o número na lista achou na lista
        if (node == null) {
            return false;
        }

        return node.getValue().equals(obj);
    }
}
