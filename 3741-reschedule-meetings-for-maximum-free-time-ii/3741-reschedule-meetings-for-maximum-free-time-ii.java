public class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = new int[n + 1];

        // Calculate gaps between meetings
        gaps[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }
        gaps[n] = eventTime - endTime[n - 1];

        // Calculate prefix maximum
        int[] maxLeft = new int[n + 1];
        maxLeft[0] = gaps[0];
        for (int i = 1; i <= n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], gaps[i]);
        }

        // Calculate suffix maximum
        int[] maxRight = new int[n + 1];
        maxRight[n] = gaps[n];
        for (int i = n - 1; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], gaps[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int duration = endTime[i] - startTime[i];
            int left = gaps[i];
            int right = gaps[i + 1];
            int adjacentFree = left + right;

            int leftMax = (i - 1 >= 0) ? maxLeft[i - 1] : 0;
            int rightMax = (i + 2 <= n) ? maxRight[i + 2] : 0;

            // If we can move the meeting into some free gap
            if (duration <= leftMax || duration <= rightMax) {
                ans = Math.max(ans, adjacentFree + duration);
            } else {
                ans = Math.max(ans, adjacentFree);
            }
        }

        return ans;
    }
}
