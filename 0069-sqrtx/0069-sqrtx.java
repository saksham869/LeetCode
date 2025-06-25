class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x; // Edge cases

        int left = 1, right = x, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid; // Use long to prevent overflow

            if (square == x) return mid; // Perfect square
            else if (square < x) {
                ans = mid; // Store possible answer
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans; // The floor value of sqrt(x)
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(4));   // Output: 2
        System.out.println(solution.mySqrt(8));   // Output: 2
        System.out.println(solution.mySqrt(16));  // Output: 4
        System.out.println(solution.mySqrt(2147395599)); // Large input test
    }
}
