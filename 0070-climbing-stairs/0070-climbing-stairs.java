public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n; // If there are 1 or 2 steps, the number of ways is n itself
        }
        
        int first = 1; // Ways to reach step 0
        int second = 2; // Ways to reach step 1
        
        // Iterate through steps from 3 to n
        for (int i = 3; i <= n; i++) {
            int current = first + second; // Ways to reach the current step
            first = second; // Move second to first
            second = current; // Move current to second
        }
        
        return second; // The second variable holds the number of ways to reach step n
    }
}
