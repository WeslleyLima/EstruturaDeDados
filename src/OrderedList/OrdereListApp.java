package OrderedList;

public class OrdereListApp {

    public static void main(String[] args) {

        List <Integer> list = new OrderedCircularDoublyLinkedList<>();

        list.add(new Integer(2));
        list.add(new Integer(0));
        list.add(new Integer(1));


        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        list.remove(2);

        System.out.println();
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

    }
}
