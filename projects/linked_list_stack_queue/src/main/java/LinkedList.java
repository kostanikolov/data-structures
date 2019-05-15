import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {

    private Node head;
    private Node tail;
    private int size;

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void addFirst(E item) {
        Node oldHead = this.head;
        this.head = new Node(item);
        this.head.setNext(oldHead);

        if (this.size() == 0) {
            this.tail = this.head;
        }

        this.size++;
    }

    public void addLast(E item) {
        Node oldTail = this.tail;
        this.tail = new Node(item);

        if (this.size() == 0) {
            this.head = this.tail;
        } else {
            oldTail.setNext(this.tail);
        }

        this.size++;
    }

    public E removeFirst() {
        if (this.size() == 0) {
            throw new IllegalArgumentException("Empty list!");
        }

        E element = this.head.getValue();
        this.head = this.head.getNext();

        this.size--;
        if (this.size() == 0) {
            this.tail = null;
        }

        return element;
    }

    public E removeLast() {
        if (this.size() == 0) {
            throw new IllegalArgumentException("Empty list!");
        }

        E element = this.tail.getValue();

        if (this.size() == 1) {
            this.head = this.tail = null;
        } else {
            this.tail = getSecondToLast();
            this.tail.setNext(null);
        }

        this.size--;
        return element;
    }

    private Node getSecondToLast() {
        Node secondLast = this.head;

        while (secondLast.getNext().getNext() != null) {
            secondLast = secondLast.getNext();
        }

        return secondLast;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator(this);
    }

    private class ListIterator implements Iterator<E> {

        private Node current;

        public ListIterator(LinkedList<E> list) {
            current = list.head;
        }

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public E next() {
            E data = this.current.getValue();
            this.current = this.current.getNext();
            return data;
        }
    }

    private class Node {
        private E value;
        private Node next;

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return this.value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
