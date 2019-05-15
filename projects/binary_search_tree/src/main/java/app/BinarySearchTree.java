package app;

import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;

    public BinarySearchTree() {
    }

    public Node getRoot() {
        return this.root;
    }

    public void insert(T value) {
        if (this.root == null) {
            this.root = new Node(value);
            return;
        }

        Node parent = null;
        Node current = this.root;
        int compare;

        while (current != null) {
            parent = current;

            compare = value.compareTo(parent.getValue());
            if (compare > 0) {
                current = current.getRight();
            } else if (compare < 0) {
                current = current.getLeft();
            } else {
                return;
            }
        }

        compare = parent.getValue().compareTo(value);
        if (compare < 0) {
            parent.setRight(new Node(value));
        } else {
            parent.setLeft(new Node(value));
        }
    }

    public boolean contains(T value) {
        Node current = this.root;

        while (current != null) {
            int compare = value.compareTo(current.getValue());

            if (compare > 0) {
                current = current.getRight();
            } else if (compare < 0) {
                current = current.getLeft();
            } else {
                break;
            }
        }

        return current != null;
    }

    public BinarySearchTree<T> search(T item) {
        throw new UnsupportedOperationException();
    }

    public void eachInOrder(Consumer<T> consumer) {
        eachInOrder(this.root, consumer);
    }

    public void eachInOrder(Node node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }

        eachInOrder(node.getLeft(), consumer);
        consumer.accept(node.getValue());
        eachInOrder(node.getRight(), consumer);
    }

    public Iterable<T> range(T from, T to) {
        throw new UnsupportedOperationException();
    }

    public class Node {
        private T value;
        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getLeft() {
            return this.left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return this.right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}

