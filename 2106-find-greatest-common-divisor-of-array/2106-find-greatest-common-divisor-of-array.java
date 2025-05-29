class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;  // Initialize min to the largest possible value
        int max = Integer.MIN_VALUE;  // Initialize max to the smallest possible value

        // Find the min and max in the array
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Compute GCD of (max, min)
        return gcd(max, min);
    }

    // Helper function to compute GCD using Euclidean Algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
