import java.util.*;

class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxSize = 0;

        // Step 1: Count how many numbers fall into each group based on digit sum
        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            int count = map.getOrDefault(sum, 0) + 1;
            map.put(sum, count);
            maxSize = Math.max(maxSize, count);
        }

        // Step 2: Count how many groups have the maximum size
        int result = 0;
        for (int count : map.values()) {
            if (count == maxSize) {
                result++;
            }
        }

        return result;
    }

    // Corrected digitSum method
    private int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
