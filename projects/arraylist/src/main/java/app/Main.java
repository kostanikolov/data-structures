package app;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);


        list.removeAt(2);

        list.add(2, 120);

//        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
//
//        list.forEach(System.out::println);
//        System.out.println("################################");
//
//        list.addLast(5);
//        list.addFirst(3);
//        list.addFirst(2);
//        list.addLast(10);
//        System.out.printf("Count = %d\n", list.size());
//
//        list.forEach(System.out::println);
//        System.out.println("################################");
//
//        list.removeFirst();
//        list.removeLast();
//        list.removeFirst();
//
//        list.forEach(System.out::println);
//        System.out.println("################################");
//
//        list.removeLast();
//
//        list.forEach(System.out::println);
//        System.out.println("################################");
    }
}
