import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> count = new HashMap<>();
        int l = 0, res = 0;

        for (int r = 0; r < fruits.length; r++) {
            count.put(fruits[r], count.getOrDefault(fruits[r], 0) + 1);

            // Shrink the window if there are more than 2 fruit types
            while (count.size() > 2) {
                int fruit = fruits[l];
                count.put(fruit, count.get(fruit) - 1);
                if (count.get(fruit) == 0) {
                    count.remove(fruit);
                }
                l++;
            }

            // Update max result
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
