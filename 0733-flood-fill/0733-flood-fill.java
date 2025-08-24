class Solution {
    int rows, cols; // to store matrix dimensions

    // Depth-First Search function
    void dfs(int row, int col, int newColor, int curColor, int[][] image) {
        // 1. Boundary check
        if (row < 0 || row >= rows || col < 0 || col >= cols) return;

        // 2. Stop if color is different or already colored
        if (image[row][col] != curColor || image[row][col] == newColor) return;

        // 3. Fill with new color
        image[row][col] = newColor;

        // 4. Explore neighbours (up, right, down, left)
        int[][] adjList = {
            {row - 1, col},  // up
            {row, col + 1},  // right
            {row + 1, col},  // down
            {row, col - 1}   // left
        };

        // 5. Recursively call dfs for each neighbour
        for (int[] neighbour : adjList) {
            dfs(neighbour[0], neighbour[1], newColor, curColor, image);
        }
    }

    // Main function
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;          // total rows
        cols = image[0].length;       // total cols

        // Call DFS only if newColor is different
        if (image[sr][sc] != color) {
            dfs(sr, sc, color, image[sr][sc], image);
        }

        return image;  // return updated image
    }
}
