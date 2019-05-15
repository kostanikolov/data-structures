package app.stacks;

public class LinkedStack<E> {

    private Node head;
    private int size;

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void push(E element) {
        if (this.size() == 0) {
            this.head = new Node(element);
            this.size++;
        } else {
            Node oldHead = this.head;
            this.head = new Node(element, oldHead);
            this.size++;
        }
    }

    public E pop() {
        if (this.size() == 0) {
            throw new IllegalArgumentException("Empty stack.");
        }

        E element = this.head.value;
        this.head = this.head.nextNode;
        this.size--;

        return element;
    }

    public boolean contains(E element) {
        Node current = this.head;

        while (current != null) {
            if (current.value == element) {
                return true;
            }
            current = current.getNextNode();
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] arr = (E[]) new Object[this.size()];

        int index = 0;
        Node curr = this.head;

        while (curr != null) {
            arr[index++] = curr.value;
            curr = curr.getNextNode();
        }

        return arr;
    }

    private class Node {

        private E value;
        private Node nextNode;

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }

        public Node getNextNode() {
            return this.nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }
}