class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k = k - 1; // we already have '1' at the start

        while (k > 0) 
        {
            long steps = countSteps(n, current, current + 1);
            if (steps <= k) {
                // move to the next prefix
                current++;
                k -= steps;
            } else {
                // go deeper in current prefix (append 0)
                current *= 10;
                k -= 1;
            }
        }
        return current
    }

    // Counts steps between [curr, next)
    private long countSteps(int n, long curr, long next) {
        long steps = 0;
        while (curr <= n) {
            steps += Math.min(n + 1L, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }
}
