class Solution {
    // Directions: up, down, left, right
    private static final int[] dirX = {-1, 1, 0, 0};
    private static final int[] dirY = {0, 0, -1, 1};
    
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;  // number of rows
        int n = grid[0].length;  // number of columns
        int maxGold = 0;  // Variable to track the maximum gold collected
        
        // Traverse the grid and start DFS from any cell that contains gold
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {  // If the cell has gold
                    maxGold = Math.max(maxGold, dfs(grid, i, j));
                }
            }
        }
        
        return maxGold;
    }
    
    // Helper DFS function to explore all directions from the current cell
    private int dfs(int[][] grid, int x, int y) {
        // If the current cell is out of bounds or contains no gold, return 0
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }
        
        // Save the current amount of gold in this cell
        int gold = grid[x][y];
        
        // Temporarily mark the cell as visited by setting it to 0
        grid[x][y] = 0;
        
        int maxGoldFromHere = 0;
        
        // Explore all four possible directions (up, down, left, right)
        for (int i = 0; i < 4; i++) {
            int newX = x + dirX[i];
            int newY = y + dirY[i];
            maxGoldFromHere = Math.max(maxGoldFromHere, dfs(grid, newX, newY));
        }
        
        // Restore the gold value in the current cell after exploring all directions
        grid[x][y] = gold;
        
        // Return the total gold collected from this path
        return gold + maxGoldFromHere;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: Regular case
        int[][] grid1 = {
            {0, 6, 0},
            {5, 8, 7},
            {0, 9, 0}
        };
        System.out.println(sol.getMaximumGold(grid1));  // Expected Output: 24

        // Test Case 2: Empty Grid
        int[][] grid2 = {};
        System.out.println(sol.getMaximumGold(grid2));  // Expected Output: 0

        // Test Case 3: Single Row Grid
        int[][] grid3 = {
            {0, 6, 0, 4, 2}
        };
        System.out.println(sol.getMaximumGold(grid3));  // Expected Output: 12

        // Test Case 4: Single Column Grid
        int[][] grid4 = {
            {1},
            {2},
            {3},
            {4},
            {5}
        };
        System.out.println(sol.getMaximumGold(grid4));  // Expected Output: 15

        // Test Case 5: Grid with All Zeros
        int[][] grid5 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        System.out.println(sol.getMaximumGold(grid5));  // Expected Output: 0

        // Test Case 6: Larger Grid with Random Values
        int[][] grid6 = {
            {1, 3, 1, 5},
            {2, 2, 4, 1},
            {5, 0, 2, 3},
            {0, 6, 1, 2}
        };
        System.out.println(sol.getMaximumGold(grid6));  // Expected Output: 16
    }
}
