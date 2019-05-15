package solutions;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

    }

    void putOccurrences(List<Integer> numbers, Map<Integer, Integer> occurrences) {
        for (Integer number : numbers) {

            if (!occurrences.containsKey(number)) {
                occurrences.put(number, 0);
            }

            int incrementCount = occurrences.get(number) + 1;
            occurrences.put(number, incrementCount);
        }
    }
}
