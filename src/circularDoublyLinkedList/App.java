package circularDoublyLinkedList;

public class App {
    public static void main(String[] args) {

        List<Integer> list = new CircularDoublyLinkedList<>(null);

        list.add(30);
        list.add(20);
        list.add(10);



        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));



        System.out.println(list.contains(40));
        System.out.println();


        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

    }
}
