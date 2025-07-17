import java.util.*;

class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 1;

        // dp[i] will store a HashMap: key = mod value of (nums[j] + nums[i]) % k, value = length
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        for (int i = 0; i < n; i++) {
            // Start a new subsequence at index i
            dp[i].put(-1, 1);  // -1 is a dummy value for initial state
            for (int j = 0; j < i; j++) {
                int mod = (nums[j] + nums[i]) % k;
                // Check if we can extend a sequence ending at j with mod
                int prevLen = dp[j].getOrDefault(mod, 1);
                int currLen = dp[i].getOrDefault(mod, 1);
                dp[i].put(mod, Math.max(currLen, prevLen + 1));
                maxLen = Math.max(maxLen, dp[i].get(mod));
            }
        }

        return maxLen;
    }
}
