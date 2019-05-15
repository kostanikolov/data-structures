package solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumAndAvg {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> numbers = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        int sum = getSum(numbers);
        double avg = getAverage(numbers);

        System.out.printf("Sum=%d; Average=%.2f\n", sum, avg);
    }

    private static int getSum(List<String> numbers) {
        int sum = 0;

        for (String number : numbers) {
            if (tryParseInt(number)) {
                sum += Integer.parseInt(number);
            }
        }

        return sum;
    }

    private static double getAverage(List<String> numbers) {
        return (double) getSum(numbers) / numbers.size();
    }

    private static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
