class Solution {

    private int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    private int[][] dp;
    private int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        m = matrix.length;
        n = matrix[0].length;

        dp = new int[m][n]; 

        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, i, j));
            }
        }

        return max;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];

        int maxPath = 1; 

        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            if (ni >= 0 && ni < m && nj >= 0 && nj < n &&
                matrix[ni][nj] > matrix[i][j]) {

                maxPath = Math.max(maxPath, 1 + dfs(matrix, ni, nj));
            }
        }

        dp[i][j] = maxPath;
        return maxPath;
    }
}