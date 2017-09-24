package SingleLinkedList;

public class SingleLinkedList<T> implements List<T> {

    private Node<T> list;

    public SingleLinkedList(){
        this.list = null;
    }

    @Override
    public void add(T obj) {

        Node<T> node = new Node<>(obj);

        if (list == null) {
            list = node;

        } else{
            node.setNext(list);
            list = node;
        }
    }

    @Override
    public T get(int position) {

        int count = 0;
        Node<T> node = list;

        if (list == null) {
            System.out.println("Lista vazia!");
        } else {
            while (count < position ){
                node = node.getNext();
                count++;
            }
        }
        return node.getValue();
    }

    @Override
    public void set(int position, T obj) {

        int count = 0;
        Node<T> node = list;

        // se a lista estiver vazia
        if (list == null) {
            list = new Node(obj);
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

        // se for o primeiro
        if (node.getValue().equals(obj)) {

            list = node.getNext();
            node.setNext(null); // set null para o coletor de lixo do java

        } else{ // se não for o primeiro

            while (node.getNext() != null) {
                if (node.getNext().getValue().equals(obj)){
                    break;
                }
                node =  node.getNext();
            }

            Node aux = node.getNext();
            node.setNext(aux.getNext());
            aux.setNext(null);
        }
    }

    @Override
    public void remove(int position) {

        int count = 0;
        Node<T> node = list;

        if (position == 0) {
            list = node.getNext();
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

        while (node.getNext() != null) {
            if (node.getValue().equals(obj))
                break;
            node = node.getNext();
        }
        return node.getValue().equals(obj);
    }
}
