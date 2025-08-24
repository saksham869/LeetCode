class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        // 1. Traverse grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 2. If land and not visited → new island
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);  // explore island
                    count++;                  // increase island count
                }
            }
        }
        return count;
    }

    // DFS to sink the island
    void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        int rows = grid.length, cols = grid[0].length;

        // Base case: stop if OOB / water / visited
        if (i < 0 || j < 0 || i >= rows || j >= cols 
            || grid[i][j] == '0' || visited[i][j]) return;

        // 1. Mark visited
        visited[i][j] = true;

        // 2. Explore neighbours (up, right, down, left)
        dfs(grid, visited, i - 1, j); // up
        dfs(grid, visited, i, j + 1); // right
        dfs(grid, visited, i + 1, j); // down
        dfs(grid, visited, i, j - 1); // left
    }
}
