package app;

import java.util.*;
import java.util.function.Consumer;

public class Tree<T> {

    private T value;
    private List<Tree<T>> children;

    public Tree(T value, Tree<T>... children) {
        this.value = value;
        this.children = new ArrayList<>();

        this.children.addAll(Arrays.asList(children));
    }

    // append output to builder
    public String print(int indent, StringBuilder builder) {
        builder.append(new String(new char[indent * 2]).replace('\0', ' '));
        builder.append(this.value).append('\n');

        for (Tree<T> child : this.children) {
            builder.append(child.print(indent + 1, new StringBuilder()));
        }

        return builder.toString();
    }

    public void each(Consumer<T> consumer) {
        Iterable<T> tree = orderDFS();

        for (T t : tree) {
            consumer.accept(t);
        }
    }

    public Iterable<T> orderDFS() {
        List<T> order = new ArrayList<>();
        this.DFS(this, order);

        return order;
    }

    private void DFS(Tree<T> tree, List<T> order) {
        for (Tree<T> child : tree.children) {
            this.DFS(child, order);
        }

        order.add(tree.value);
    }

    public Iterable<T> orderBFS() {
        List<T> result = new ArrayList<>();
        Deque<Tree<T>> queue = new ArrayDeque<>();
        queue.offer(this);

        while (!queue.isEmpty()) {
            Tree<T> current = queue.poll();
            result.add(current.value);

            for (Tree<T> child : current.children) {
                queue.offer(child);
            }
        }

        return result;
    }
}
