class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long curr = 0;  // Using long to avoid overflow
        long minVal = 0;
        long maxVal = 0;

        for (int d : differences) {
            curr += d;
            minVal = Math.min(minVal, curr);
            maxVal = Math.max(maxVal, curr);
        }

        long totalRange = (upper - maxVal) - (lower - minVal) + 1;

        return totalRange <= 0 ? 0 : (int) totalRange;
    }
}
