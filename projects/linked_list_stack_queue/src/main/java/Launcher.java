import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Print(4,5,6);
    }

    private static void Print(int... values) {

        int[] arr = values;

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
