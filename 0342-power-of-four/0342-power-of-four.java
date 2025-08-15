class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;

        // Check power of two
        if ((n & (n - 1)) != 0) return false;

        // Ensure power of four (set bit must be in an even position)
        return (n & 0xAAAAAAAA) == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfFour(1));   // true (4^0)
        System.out.println(solution.isPowerOfFour(4));   // true (4^1)
        System.out.println(solution.isPowerOfFour(16));  // true (4^2)
        System.out.println(solution.isPowerOfFour(8));   // false
        System.out.println(solution.isPowerOfFour(32));  // false
    }
}
