package solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class CountOfOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Map<Integer, Integer> occurrences = new TreeMap<>();

        Main main = new Main();
        main.putOccurrences(numbers, occurrences);

        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            System.out.println(String.format("%d -> %d times", entry.getKey(), entry.getValue()));
        }
    }
}
