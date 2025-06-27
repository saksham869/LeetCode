class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1;           // Smallest number in the table
        int high = m * n;      // Largest number in the table

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Count how many numbers in the table are <= mid
            int count = countLessEqual(mid, m, n);

            if (count < k) {
                // Too few numbers <= mid → mid is too small
                low = mid + 1;
            } else {
                // Enough numbers ≤ mid → maybe it's the answer
                high = mid;
            }
        }

        // At the end, low == high and is the k-th smallest number
        return low;
    }

    // Counts how many numbers in the m x n table are <= target
    private int countLessEqual(int mid, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            // In row i, count how many elements are ≤ mid
            count += Math.min(n, mid / i);
        }
        return count;
    }
}
