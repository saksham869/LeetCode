class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;        // number of rows
        int m = grid[0].length;     // number of columns

        // Create a DP table to store minimum path sum at each cell
        int[][] dp = new int[n][m];

        // Step 1: Initialize the starting point
        dp[0][0] = grid[0][0];

        // Step 2: Fill the first row (can only come from the left)
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // Step 3: Fill the first column (can only come from the top)
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Step 4: Fill the rest of the grid
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        // Step 5: The answer is in the bottom-right cell
        return dp[n - 1][m - 1];
    }
}
