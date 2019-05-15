package app.stacks;

import java.util.Arrays;

public class ArrayStack<T> {

    private static final int INITIAL_CAPACITY = 16;

    private T[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        this.elements = (T[]) new Object[INITIAL_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        this.elements = (T[]) new Object[capacity];
    }

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void push(T element) {
        if (this.size() == 0) {
            this.elements[0] = element;
            this.size++;
        } else {
            if (this.size() == this.elements.length) {
                this.grow();
            }

            System.arraycopy(this.elements, 0, this.elements, 1, this.size());
            this.elements[0] = element;
            this.size++;
        }
    }

    public T pop() {
        if (this.size() == 0) {
            throw new IllegalArgumentException("Empty stack.");
        }

        T element = this.elements[0];

        for (int i = 1; i < this.size(); i++) {
            this.elements[i - 1] = this.elements[i];
        }

        this.elements[this.size() - 1] = null;
        this.size--;
        return element;
    }

    public T[] toArray() {
        return Arrays.copyOf(this.elements, this.size());
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        T[] newArray = (T[]) new Object[this.size() * 2];
        System.arraycopy(this.elements, 0, newArray, 0, this.elements.length);
        this.elements = newArray;
    }
}