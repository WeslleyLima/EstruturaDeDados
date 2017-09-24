package OrderedList;

public class Node<T> {

    private T value;
    private Node<T> next;
    private Node<T> privious;

    public Node() {
        this(null, null);
    }

    public Node(T value) {
        this(value, null);
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrivious() {
        return privious;
    }

    public void setPrivious(Node<T> privious) {
        this.privious = privious;
    }
}
