package solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class RemoveOddOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Map<Integer, Integer> occurrences = new LinkedHashMap<>();

        Main main = new Main();
        main.putOccurrences(numbers, occurrences);

        for (Integer number : numbers) {
            if (occurrences.get(number) % 2 == 0) {
                System.out.print(number + " ");
            }
        }
    }
}
