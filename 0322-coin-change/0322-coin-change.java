class Solution {
    public int coinChange(int[] coins, int amount) {
        // Edge case
        if (amount < 1) return 0;

        // DP array to store minimum coins for each amount
        int[] minCoinsDP = new int[amount + 1];

        // Fill from 1 to amount
        for (int i = 1; i <= amount; i++) {
            minCoinsDP[i] = Integer.MAX_VALUE;

            // Try each coin
            for (int coin : coins) {
                if (coin <= i && minCoinsDP[i - coin] != Integer.MAX_VALUE) {
                    minCoinsDP[i] = Math.min(minCoinsDP[i], 1 + minCoinsDP[i - coin]);
                }
            }
        }

        return minCoinsDP[amount] == Integer.MAX_VALUE ? -1 : minCoinsDP[amount];
    }
}
