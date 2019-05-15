package app;

public class Launcher {
    public static void main(String[] args) {

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);
        bst.insert(23);

        bst.eachInOrder(x -> System.out.print(x + " "));

        System.out.println();
    }
}
