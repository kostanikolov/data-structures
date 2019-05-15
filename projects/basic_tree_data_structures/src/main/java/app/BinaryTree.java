package app;

import java.util.function.Consumer;

public class BinaryTree<T> {

    private T value;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;

    public BinaryTree(T value) {
        this.value = value;
    }

    public BinaryTree(T value, BinaryTree<T> child) {
        this.value = value;
        this.leftChild = child;
    }

    public BinaryTree(T value, BinaryTree<T> leftChild, BinaryTree<T> rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    // append output to builder
    public String printIndentedPreOrder(int indent, StringBuilder builder) {
        builder.append(new String(new char[indent * 2]).replace('\0', ' '));
        builder.append(this.value).append('\n');

        if (this.leftChild != null) {
            builder.append(this.leftChild.printIndentedPreOrder(indent + 1, new StringBuilder()));
        }

        if (this.rightChild != null) {
            builder.append(this.rightChild.printIndentedPreOrder(indent + 1, new StringBuilder()));
        }

        return builder.toString();
    }

    public void eachPreOrder(Consumer<T> consumer) {
        // Pre-order: left child, root, right child

        consumer.accept(this.value);

        if (this.leftChild != null) {
            this.leftChild.eachPreOrder(consumer);
        }

        if (this.rightChild != null) {
            this.rightChild.eachPreOrder(consumer);
        }
    }

    public void eachInOrder(Consumer<T> consumer) {
        // In-order: left child, root, right child

        if (this.leftChild != null) {
            this.leftChild.eachInOrder(consumer);
        }

        consumer.accept(this.value);

        if (this.rightChild != null) {
            this.rightChild.eachInOrder(consumer);
        }
    }

    public void eachPostOrder(Consumer<T> consumer) {
        // Post-order: left child, right child, root

        if (this.leftChild != null) {
            this.leftChild.eachPostOrder(consumer);
        }

        if (this.rightChild != null) {
            this.rightChild.eachPostOrder(consumer);
        }

        consumer.accept(this.value);
    }
}
















