class Solution {
    public int findLucky(int[] arr) {
        // Count frequencies, but ignore values > n
        int n = arr.length;
        int[] count = new int[n + 1];
        for (int a : arr) {
            if (a <= n) {
                count[a]++;
            }
        }

        // Search from largest to smallest for a lucky integer
        for (int i = n; i >= 1; i--) {
            if (count[i] == i) {
                return i;
            }
        }

        return -1;
    }
}
