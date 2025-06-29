class Solution {

    // \U0001f490 Helper: How many bouquets can be made by 'mid' day?
    private int getNumOfBouquets(int[] bloomDay, int mid, int k) {
        int numOfBouquets = 0;  // Total bouquets formed
        int count = 0;          // Count of consecutive bloomed flowers

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= mid) {
                count++;  // ✅ flower bloomed by day 'mid'
            } else {
                count = 0;  // ❌ break: flowers must be adjacent
            }

            // \U0001f3af Make a bouquet when we have k adjacent flowers
            if (count == k) {
                numOfBouquets++;  // Made 1 bouquet
                count = 0;        // Reset for next bouquet
            }
        }

        return numOfBouquets;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int start = 0;
        int end = 0;

        // \U0001f50d Set upper bound = max bloom day in array
        for (int day : bloomDay) {
            end = Math.max(end, day);
        }

        int minDays = -1;  // Default if not found

        // \U0001f9e0 Binary Search on days
        while (start <= end) {
            int mid = (start + end) / 2;

            // \U0001f490 If mid day allows us to make enough bouquets
            if (getNumOfBouquets(bloomDay, mid, k) >= m) {
                minDays = mid;      // ✅ valid candidate
                end = mid - 1;      // Try to minimize further
            } else {
                start = mid + 1;    // ❌ not enough → need more days
            }
        }

        return minDays;
    }
}
