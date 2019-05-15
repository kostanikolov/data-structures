import java.util.Iterator;
import java.util.function.Consumer;

public class DoublyLinkedList<E> implements Iterable<E> {

    private ListNode<E> head;
    private ListNode<E> tail;
    private int size;

    public DoublyLinkedList() {
    }

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void addFirst(E element) {
        if (this.size() == 0) {
            this.head = this.tail = new ListNode<>(element);
        } else {
            ListNode<E> newHead = new ListNode<>(element);
            newHead.setNextNode(this.head);
            this.head.setPrevNode(newHead);
            this.head = newHead;
        }

        this.size++;
    }

    public void addLast(E element) {
        if (this.size == 0) {
            this.head = this.tail = new ListNode<>(element);
        } else {
            ListNode<E> newTail = new ListNode<>(element);
            newTail.setPrevNode(this.tail);
            this.tail.setNextNode(newTail);
            this.tail = newTail;
        }

        this.size++;
    }

    public E removeFirst() {
        if (this.size() == 0) {
            throw new IllegalArgumentException("Empty list");
        }

        E firstElement = this.head.getValue();

        this.head = this.head.getNextNode();
        if (this.head != null) {
            this.head.setPrevNode(null);
        } else {
            this.tail = null;
        }

        this.size--;
        return firstElement;
    }

    public E removeLast() {
        if (this.size() == 0) {
            throw new IllegalArgumentException("Empty list");
        }

        E lastElement = this.tail.getValue();

        this.tail = this.tail.getPrevNode();
        if (this.tail != null) {
            this.tail.setNextNode(null);
        } else {
            this.head = null;
        }

        this.size--;
        return lastElement;
    }

    @SuppressWarnings("unchecked")
    public E[] toArray() {

        E[] array = (E[]) new Object[this.size()];
        int index = 0;
        ListNode<E> currentNode = this.head;

        while (currentNode != null) {
            array[index++] = currentNode.getValue();
            currentNode = currentNode.getNextNode();
        }

        return array;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator(this);
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        ListNode<E> currentNode = this.head;

        while (currentNode != null) {
            action.accept(currentNode.value);
            currentNode = currentNode.getNextNode();
        }
    }

    class ListIterator implements Iterator<E> {
        ListNode<E> current;

        // initialize pointer to head of the list for iteration
        public ListIterator(DoublyLinkedList<E> list) {
            current = list.head;
        }

        // returns false if next element does not exist
        public boolean hasNext() {
            return current != null;
        }

        // return current data and update pointer
        public E next() {
            E data = current.getValue();
            current = current.getNextNode();
            return data;
        }
    }

    private class ListNode<T> {

        private T value;
        private ListNode<T> nextNode;
        private ListNode<T> prevNode;

        public ListNode(T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }

        private void setValue(T value) {
            this.value = value;
        }

        public ListNode<T> getNextNode() {
            return this.nextNode;
        }

        public void setNextNode(ListNode<T> nextNode) {
            this.nextNode = nextNode;
        }

        public ListNode<T> getPrevNode() {
            return this.prevNode;
        }

        public void setPrevNode(ListNode<T> prevNode) {
            this.prevNode = prevNode;
        }
    }
}
