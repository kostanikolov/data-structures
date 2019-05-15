package app;

public class ArrayList<T> {
    private static final int INITIAL_CAPACITY = 2;

    private T[] items;
    private int count;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        this.items = (T[]) new Object[INITIAL_CAPACITY];
        this.count = 0;
    }

    public T get(int index) {
        if (index >= this.count || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        return this.items[index];
    }

    public void add(T item) {
        if (this.count == this.items.length) {
            this.resize();
        }

        this.items[count++] = item;
    }

    public void add(int index, T item) {
        if (index >= this.count || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        this.items[index] = item;
    }

    public T removeAt(int index) {
        if (index >= this.count || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        T element = this.items[index];
        this.items[index] = null;
        this.shift(index);
        this.count--;

        if (this.count <= this.items.length / 4) {
            this.shrink();
        }

        return element;
    }

    private void shift(int index) {
        for (int i = index; i < this.count; i++) {
            this.items[i] = this.items[i + 1];
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] copy = (T[]) new Object[this.items.length * 2];

        for (int i = 0; i < this.items.length; i++) {
            copy[i] = this.items[i];
        }

        this.items = copy;
    }

    @SuppressWarnings("unchecked")
    private void shrink() {
        T[] copy = (T[]) new Object[this.items.length / 2];

        for (int i = 0; i < this.count; i++) {
            copy[i] = this.items[i];
        }

        this.items = copy;
    }
}
