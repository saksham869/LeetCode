import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int result = 0;

        for (int[] domino : dominoes) {
            // Normalize the domino
            int a = domino[0];
            int b = domino[1];
            int key = a < b ? a * 10 + b : b * 10 + a;

            // Add the current count to result
            result += countMap.getOrDefault(key, 0);

            // Increment the count for this domino
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }

        return result;
    }
}
