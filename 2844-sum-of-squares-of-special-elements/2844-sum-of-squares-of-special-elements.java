class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                int index = i - 1; // because array is 0-indexed
                sum += nums[index] * nums[index];
            }
        }

        return sum;
    }
}
