class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int cash = 0;             // profit with no stock in hand
        int hold = -prices[0];    // profit if we bought on day 0

        for (int i = 1; i < n; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);  // sell today
            hold = Math.max(hold, cash - prices[i]);        // buy today
        }

        return cash;
    }
}
