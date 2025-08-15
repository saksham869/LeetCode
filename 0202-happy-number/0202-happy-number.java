import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);  // Store the current number
            n = getSumOfSquares(n);  // Compute the next number
        }

        return n == 1; // True if we reach 1, false if we detect a cycle
    }

    private int getSumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;  // Extract the last digit
            sum += digit * digit;  // Square and add it
            num /= 10;  // Remove last digit
        }
        return sum;
    }
}
