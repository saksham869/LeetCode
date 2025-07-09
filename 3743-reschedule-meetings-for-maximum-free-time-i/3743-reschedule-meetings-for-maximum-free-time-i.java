class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        // Compute gaps: before first, between meetings, after last
        int[] gaps = new int[n + 1];
        gaps[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }
        gaps[n] = eventTime - endTime[n - 1];

        // Use sliding window of size k+1 to get maximum sum of consecutive gaps
        long windowSum = 0;
        for (int i = 0; i <= k; i++) windowSum += gaps[i];
        long best = windowSum;

        for (int i = k + 1; i <= n; i++) {
            windowSum += gaps[i] - gaps[i - k - 1];
            best = Math.max(best, windowSum);
        }
        return (int) best;
    }
}
