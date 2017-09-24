package doubleLinkedList;

public class AppDoublyLinkedList {


    public static void main(String[] args) {

        List<Integer> list = new DoubleLinkedList<>(null);

        list.add(0);
        list.add(1);
        list.add(2);

        System.out.println(list.contains(5));
    }
}
