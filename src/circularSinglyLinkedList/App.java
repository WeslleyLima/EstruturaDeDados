package circularSinglyLinkedList;

public class App {

    public static void main(String[] args) {

        List<Integer> list = new CircularSingleLinkedList<>();

        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));


        list.set(2, 99);

        System.out.println();
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));

        System.out.println(list.contains(99));






    }
}
