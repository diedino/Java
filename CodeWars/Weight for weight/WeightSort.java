import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WeightSort {
	
	public static String orderWeight(String strng) {
		int[] numbers = Arrays.stream(strng.split("\\s+")).mapToInt(Integer::parseInt).toArray();
		Map<Integer, Integer> map = new HashMap<Ingeter, Integer>();
	}
}

/*

import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //String strng = args[0];
        Scanner reader = new Scanner(System.in);
        String strng = reader.next();
        int[] numbers = Arrays.stream(strng.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer key : numbers) {
            map.put(key, weight(key));
        }
        Map<Integer, Integer> sorted = map
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(
                        toMap(e->e.getKey(), e-> e.getValue(), (e1, e2) -> e2,
                                LinkedHashMap::new));
        System.out.println(sorted);
    }

    public static int weight(int key) {
        int sum = 0;
        while (key > 0) {
            sum = sum + key % 10;
            key = key / 10;
        }
        return sum;
    }
}

*/