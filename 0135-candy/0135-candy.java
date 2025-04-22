public class Solution {
    public int candy(int[] ratings) {
        // Your candy distribution logic
        int n = ratings.length;
        int[] candies = new int[n];
        
        // Initialize candies array
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        // Left to right pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to left pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Calculate total candies
        int totalCandies = 0;
        for (int i = 0; i < n; i++) {
            totalCandies += candies[i];
        }
        return totalCandies;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ratings = {1, 3, 2, 1};  // Example ratings array
        int result = solution.candy(ratings);
        System.out.println("Total candies: " + result);
    }
}
