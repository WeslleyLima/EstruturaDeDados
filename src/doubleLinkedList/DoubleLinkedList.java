package doubleLinkedList;

public class DoubleLinkedList<T> implements List<T> {

    private Node<T> list;

    public DoubleLinkedList(T value) {
        this.list = null;
    }

    @Override
    public void add(T obj) {

        Node<T> node = new Node<>(obj);

        if (list == null) {
            list = node;
        } else {
            list.setPrivious(node);
            node.setNext(list);
            list = node;
        }
    }

    @Override
    public void set(int position, T obj) {

        int count = 0;
        Node<T> node = list;

        if (list == null) {
            list = new Node<>(obj);
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

        Node<T> node = list;

//        // MÉTODO 1
//        if (node.getValue().equals(obj)) {
//            list = node.getNext();
//            list.setPrivious(null);
//            node.setNext(null);
//        } else {
//            while (node.getNext() != null) {
//                if (node.getValue().equals(obj)) {
//                    break;
//                }
//                node = node.getNext();
//            }
//            node.getPrivious().setNext(node.getNext());
//            node.getNext().setPrivious(node.getPrivious());
//            node.setPrivious(null);
//            node.setNext(null);
//        }

        // MÉTODO 2
        while (node != null) {

            if (node.getValue().equals(obj)) {

                if (node.getPrivious() != null)
                    node.getPrivious().setNext(node.getNext());
                else
                    list = node.getNext();

                if (node.getNext() != null)
                    node.getNext().setPrivious(node.getPrivious());
                else
                    node.getNext().setNext(null);

                node.setNext(null);
                node.setPrivious(null);
                break;
            }
            node = node.getNext();
        }
    }

    @Override
    public void remove(int position) {

        int count = 0;
        Node<T> node = list;

        if (position == 0) {
            list = node.getNext();
            list.setPrivious(null);
            node.setNext(null);
        } else {

            while (count < position) {
                node = node.getNext();
                count++;
            }

            node.getPrivious().setNext(node.getNext());

            if (node.getNext() != null)
                node.getNext().setPrivious(node.getPrivious());

            node.setPrivious(null);
            node.setNext(null);
        }
    }

    @Override
    public T get(int position) {

        int count = 0;
        Node<T> node = list;

        if (list == null)
            return null;
        else {
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

        Node<T> node = list;

        while (node.getNext() != null) {
            node = node.getNext();
        }
        return node.getValue();
    }

    @Override
    public boolean isEmpty() {
        return list == null;
    }

    @Override
    public boolean contains(T obj) {

        Node<T> node = list;
        while (node != null) {
            if (node.getValue().equals(obj))
                break;
            node =  node.getNext();
        }

        // não achou na lista
        if (node == null) {
            return false;
        }

        return node.getValue().equals(obj);
    }
}
