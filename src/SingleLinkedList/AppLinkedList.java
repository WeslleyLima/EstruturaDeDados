package SingleLinkedList;

public class AppLinkedList {

    public static void main(String[] args) {

        List<Integer> list = new SingleLinkedList<Integer>();

        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(0);


        list.remove(4);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));


    }
}
