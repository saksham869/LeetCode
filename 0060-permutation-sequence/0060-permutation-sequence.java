import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        // Initialize the list of numbers and compute factorials
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            factorial[i] = factorial[i - 1] * i;
        }

        k--; // Convert k to zero-based index

        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k -= index * factorial[n - i];
        }

        return sb.toString();
    }
}