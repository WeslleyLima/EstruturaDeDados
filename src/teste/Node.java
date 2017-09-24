package teste;

public class Node<T> {

    private Node<T> node;
    private T value;

    public Node() {

    }

    public Node(Node<T> node, T value) {
        this.node = node;
        this.value = value;
    }

    public Node<T> getNode() {
        return node;
    }

    public void setNode(Node<T> node) {
        this.node = node;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
