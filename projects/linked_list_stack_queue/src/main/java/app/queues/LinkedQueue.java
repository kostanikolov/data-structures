package app.queues;

public class LinkedQueue<E> {

    private QueueNode head;
    private QueueNode tail;
    private int size;

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void enqueue(E element) {
        if (this.size() == 0) {
            this.head = this.tail = new QueueNode(element);
        } else {
            QueueNode newTail = new QueueNode(element);
            newTail.setPrevNode(this.tail);
            this.tail.setNextNode(newTail);
            this.tail = newTail;
        }

        this.size++;
    }

    public E dequeue() {
        if (this.size() == 0) {
            throw new IllegalArgumentException("Empty queue!");
        }

        E element = this.head.getValue();
        this.head = this.head.getNextNode();

        if (this.head != null) {
            this.head.setPrevNode(null);
        } else {
            this.tail = null;
        }

        this.size--;
        return element;
    }

    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] arr = (E[]) new Object[this.size()];

        int index = 0;
        QueueNode current = this.head;

        while (current != null) {
            arr[index++] = current.getValue();
            current = current.getNextNode();
        }

        return arr;
    }

    private class QueueNode {
        private E value;

        private QueueNode nextNode;
        private QueueNode prevNode;

        public QueueNode(E value) {
            this.value = value;
        }

        public E getValue() {
            return this.value;
        }

        private void setValue(E value) {
            this.value = value;
        }

        public QueueNode getNextNode() {
            return this.nextNode;
        }

        public void setNextNode(QueueNode nextNode) {
            this.nextNode = nextNode;
        }

        public QueueNode getPrevNode() {
            return this.prevNode;
        }

        public void setPrevNode(QueueNode prevNode) {
            this.prevNode = prevNode;
        }
    }
}
