import java.util.*;

class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[1] - b[1]); // sort by end time
        
        // Create an array of end times for binary search
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            ends[i] = events[i][1];
        }

        // dp[i][j] = max value using first i events and attending j events
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            int[] curr = events[i - 1];
            int start = curr[0], end = curr[1], value = curr[2];

            // Find last event that doesn't overlap
            int last = binarySearch(ends, start - 1);

            for (int j = 1; j <= k; j++) {
                // Option 1: Don't take current event
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);

                // Option 2: Take current event
                dp[i][j] = Math.max(dp[i][j], dp[last + 1][j - 1] + value);
            }
        }

        return dp[n][k];
    }

    // Binary search: Find the rightmost event that ends before or at 'time'
    private int binarySearch(int[] ends, int time) {
        int low = 0, high = ends.length - 1, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (ends[mid] <= time) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
