package solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LongestSubSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] data = findLongestSubSequence(numbers);
        int number = data[0];
        int count = data[1];

        printResult(number, count);
    }

    private static int[] findLongestSubSequence(List<Integer> numbers) {
        int number = 0;
        int maxCount = 0;

        for (int i = 0; i < numbers.size(); i++) {
            int currentCount = 1;

            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    currentCount++;
                } else {
                    break;
                }
            }

            if (currentCount > maxCount) {
                number = numbers.get(i);
                maxCount = currentCount;
            }
        }

        return new int[]{number, maxCount};
    }

    private static void printResult(int number, int count) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count; i++) {
            result.append(number).append(" ");
        }

        System.out.println(result.toString().trim());
    }
}
