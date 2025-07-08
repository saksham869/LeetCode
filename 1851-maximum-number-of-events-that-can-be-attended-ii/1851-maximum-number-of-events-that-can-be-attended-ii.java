import java.util.*;

class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        // Sort events by start time
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        
        // Prepare array of start times for binary search
        int[] starts = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = events[i][0];
        }
        
        // DP memo: dp[i][j] = max value from event i with j events left
        Integer[][] memo = new Integer[n][k + 1];
        
        return dfs(0, k, events, starts, memo);
    }
    
    private int dfs(int idx, int rem, int[][] events, int[] starts, Integer[][] memo) {
        if (idx >= events.length || rem == 0) return 0;
        if (memo[idx][rem] != null) return memo[idx][rem];
        
        // Option 1: skip current event
        int ans = dfs(idx + 1, rem, events, starts, memo);
        
        // Option 2: attend current event
        int end = events[idx][1];
        int value = events[idx][2];
        
        // Find next event whose start >= current end + 1
        int nextIdx = lowerBound(starts, end + 1);
        
        int take = value + dfs(nextIdx, rem - 1, events, starts, memo);
        
        ans = Math.max(ans, take);
        memo[idx][rem] = ans;
        return ans;
    }
    
    // Standard binary search for first starts[pos] >= target
    private int lowerBound(int[] starts, int target) {
        int lo = 0, hi = starts.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (starts[mid] >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}
