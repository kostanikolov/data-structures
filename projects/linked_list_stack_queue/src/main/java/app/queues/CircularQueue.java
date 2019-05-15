package app.queues;

public class CircularQueue<E> {

    private static final int DEFAULT_CAPACITY = 16;

    private E[] elements;
    private int startIndex;
    private int endIndex;
    private int size;

    @SuppressWarnings("unchecked")
    public CircularQueue() {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public CircularQueue(int initialCapacity) {
        this.elements = (E[]) new Object[initialCapacity];
    }

    public int size() {
        return this.size;
    }

    private  void setSize(int size) {
        this.size = size;
    }

    public void enqueue(E element) {
        if (this.size() == this.elements.length) {
            this.grow();
        }

        this.elements[this.endIndex] = element;
        this.endIndex = (this.endIndex + 1) % this.elements.length;
        this.size++;
    }

    public E dequeue() {
        if (this.size() == 0) {
            throw new IllegalArgumentException("Empty queue.");
        }

        E element = this.elements[this.startIndex];

        this.elements[this.startIndex] = null;
        this.startIndex = (this.startIndex + 1) % this.elements.length;
        this.size--;

        return element;
    }

    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] arr = (E[]) new Object[this.size()];
        this.copyAllElementsTo(arr);
        return arr;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        E[] newElements = (E[]) new Object[this.elements.length * 2];
        this.copyAllElementsTo(newElements);
        this.elements = newElements;

        this.startIndex = 0;
        this.endIndex = this.size();
    }

    private void copyAllElementsTo(E[] newElements) {
        int sourceIndex = this.startIndex;
        int destIndex = 0;

        for (int i = 0; i < this.size(); i++) {
            newElements[destIndex] = this.elements[sourceIndex];
            sourceIndex = (sourceIndex + 1) % this.elements.length;
            destIndex++;
        }
    }
}
