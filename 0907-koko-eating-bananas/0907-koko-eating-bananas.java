class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMax(piles);

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canEatAll(piles, h, mid)) {
                high = mid; // Try smaller k
            } else {
                low = mid + 1; // Try larger k
            }
        }

        return low;
    }

    private boolean canEatAll(int[] piles, int h, int k) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += (pile + k - 1) / k; // Same as ceil(pile / k)
        }
        return totalHours <= h;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int p : piles) max = Math.max(max, p);
        return max;
    }
}
