class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minPrice = Integer.MAX_VALUE;  // Track the minimum price
        int maxProfit = 0;  // Track the maximum profit

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;  // Update the minimum price
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);  // Update max profit
            }
        }

        return maxProfit;
    }
}
