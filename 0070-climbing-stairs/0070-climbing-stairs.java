public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n; // If there are 1 or 2 steps, the number of ways is n itself
        }
        
        int[] dp = new int[n + 1]; // dp[i] will store the number of ways to reach step i
        dp[0] = 1; // Base case: There's 1 way to stay on the ground (step 0)
        dp[1] = 1; // Base case: There's 1 way to reach the first step
        
        // Fill the dp array using the recurrence relation
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // Number of ways to reach step i
        }
        
        return dp[n]; // Return the number of ways to reach the nth step
    }
}
