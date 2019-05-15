import java.util.*;

class Program {
    public static void main(String[] args) {
        sequenceNtoM();
    }

    private static void siteUndo() {
        Scanner scanner = new Scanner(System.in);

        Stack<String> stack = new Stack<>();

        String previous = null;
        String command = scanner.nextLine();
        while (!"exit".equals(command)) {

            if ("back".equals(command)) {
                if (stack.size() != 0) {
                    System.out.println(stack.pop());
                }

                previous = null;

            } else {
                if (previous != null) {
                    stack.push(previous);
                }

                previous = command;
            }

            command = scanner.nextLine();
        }
    }

    private static void matchingBrackets() {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        String expression = scanner.nextLine();

        for (int index = 0; index < expression.length(); index++) {

            char ch = expression.charAt(index);
            if (ch == '(') {
                stack.push(index);
            } else if (ch == ')') {
                int startIndex = stack.pop();
                String contents = expression.substring(startIndex, index + 1);
                System.out.println(contents);
            }
        }
    }

    private static void reverseStack() {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();
        String[] inputArray = scanner.nextLine().split("\\s+");
        Arrays.stream(inputArray).map(Integer::parseInt).forEach(stack::push);

        int len = stack.size();
        for (int i = 0; i < len; i++) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    private static void calculateSequence() {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(n);

        int index = 0;
        int[] members = new int[50];

        while (queue.size() > 0) {
            int element = queue.poll();

            members[index++] = element;
            if (index == 50) {
                break;
            }

            queue.offer(element + 1);
            queue.offer(2 * element + 1);
            queue.offer(element + 2);
        }

        System.out.println(Arrays.toString(members).replace("[", "").replace("]", ""));
    }

    private static void sequenceNtoM() {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> result = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("\\s+");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        if (start > end) {
            return;
        }

        Deque<Item> queue = new ArrayDeque<>();
        Item startItem = new Item();
        startItem.value = start;

        queue.offer(startItem);
        while (true) {
            Item element = queue.poll();

            assert element != null;
            if (element.value == end) {
                while (element != null) {
                    result.push(element.value);
                    element = element.prevItem;
                }

                while (!result.isEmpty()) {
                    System.out.print(result.pop());
                    if (result.isEmpty()) {
                        return;
                    }
                    System.out.print(" -> ");
                }
            }

            Item newItem1 = new Item(element.value + 1, element);
            Item newItem2 = new Item(element.value + 2, element);
            Item newItem3 = new Item(element.value * 2, element);

            queue.offer(newItem1);
            queue.offer(newItem2);
            queue.offer(newItem3);
        }
    }

    private static class Item {
        private int value;
        private Item prevItem;

        Item() {
        }

        Item(int value, Item prevItem) {
            this.value = value;
            this.prevItem = prevItem;
        }
    }
}
