package circularSinglyLinkedList;

public class CircularSingleLinkedList<T> implements List<T> {

    private Node<T> list;
    private Node<T> last;


    public CircularSingleLinkedList() {
        list = null;
    }

    @Override
    public void add(T obj) {

        Node<T> node = new Node<>(obj);
        // Se lista vazia
        if (list == null) {
            list = node;
            node.setNext(list);
            last = list;
        } else {
            last.setNext(node);
            node.setNext(list);
            last = node;
        }

    }

    @Override
    public void set(int position, T obj) {

        int count = 0;
        Node<T> node = list;

        // se a lista estiver vazia
        if (list == null) {
            list = new Node(obj);
            list.setNext(list);
            last = list;
        } else {
            while (count < position) {
                node = node.getNext();
                count++;
            }
            node.setValue(obj);
        }
    }

    @Override
    public void remove(T obj) {

        if (list == null) {
            System.out.println("Lista Vazia!");
        } else {
            Node<T> node = list;

            // Se for o primeiro obj
            if (node.getValue().equals(obj)) {

                last.setNext(node.getNext());
                list = node.getNext();
                node.setNext(null);

            } else {

                while (node.getNext() != list) {
                    if (node.getNext().getValue().equals(obj))
                        break;
                    node = node.getNext();
                }

                Node aux = node.getNext();
                node.setNext(aux.getNext());
                aux.setNext(null);
            }
        }
    }

    @Override
    public void remove(int position) {

        int count = 0;
        Node<T> node = list;

        if (position == 0) {
            list = node.getNext();
            last.setNext(list);
            node.setNext(null);
        } else {
            while (count < position - 1) {
                node = node.getNext();
                count++;
            }
            Node aux = node.getNext();
            node.setNext(aux.getNext());
            aux.setNext(null);
        }
    }

    @Override
    public T get(int position) {

        int count = 0;
        Node<T> node = list;

        while (count < position) {
            node = node.getNext();
            count++;
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

        while (node.getNext() != list) {
            if (node.getValue().equals(obj))
                break;
            node = node.getNext();
        }
        return node.getValue().equals(obj);
    }
}
