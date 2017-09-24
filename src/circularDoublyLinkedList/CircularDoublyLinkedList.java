package circularDoublyLinkedList;

public class CircularDoublyLinkedList<T> implements List<T> {

    private Node<T> list;
    private Node<T> last;

    public CircularDoublyLinkedList(T value) {
        this.list = null;
        this.last = null;
    }

    @Override
    public void add(T obj) {
        Node<T> node = new Node<>(obj);

        if (list == null) {
            list = node;
            last = node;
        } else {
            list.setPrivious(node);
            node.setNext(list);
            node.setPrivious(last);
            last.setNext(node);
            list = node;
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

        // SE A LIST ESTIVER VAZIA
        if (list == null)
            System.out.println("Lista Vazia");

        // SE O OBJ ESTIVER NO PRIMEIRO NÓ
        if (node.getValue().equals(obj)) {

            list = list.getNext();
            node.setNext(null);
            node.setPrivious(null);
            list.setPrivious(last);
            last.setNext(list);

        } else {

            // variável node aponto para o segundo nó
            node = list.getNext();

            while (node != list) {
                if (node.getValue().equals(obj)) {
                    break;
                }
                node = node.getNext();
            }

            // se não achar o valor na list
            if (node == list) {
                System.out.println("Valor não encontrado!");
            // se achou obj na list
            } else {
                node.getPrivious().setNext(node.getNext());
                node.getNext().setPrivious(node.getPrivious());

                // se o obj estiver no last nó
                if (node == last)
                    last = node.getPrivious();

                node.setPrivious(null);
                node.setNext(null);
            }
        }
    }

    @Override
    public void remove(int position) {
        int count = 0;
        Node<T> node = list;

        if (position == 0) {

            list = list.getNext();
            node.setNext(null);
            node.setPrivious(null);
            list.setPrivious(last);
            last.setNext(list);
        } else {
            while (count < position) {
                node = node.getNext();
                count++;
            }

            node.getPrivious().setNext(node.getNext());
            node.getNext().setPrivious(node.getPrivious());

            // se o obj estiver no last nó
            if (node == last)
                last = node.getPrivious();

            node.setPrivious(null);
            node.setNext(null);

        }
    }

    @Override
    public T get(int position) {

        int count = 0;
        Node<T> node = list;

        if (list == null) {
            return null;
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

        while (node != last) {

            if (node.getValue().equals(obj))
                break;
            node = node.getNext();
        }

        return node.getValue().equals(obj);
    }
}
