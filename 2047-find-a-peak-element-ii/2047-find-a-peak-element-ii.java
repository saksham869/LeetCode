class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int left = 0, right = cols - 1;

        while (left <= right) {
            int midCol = left + (right - left) / 2;
            System.out.println("Checking midCol: " + midCol);

            // Find the row with the maximum element in midCol
            int maxRow = 0;
            for (int i = 0; i < rows; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }

            int midVal = mat[maxRow][midCol];
            System.out.println("→ Max value in col " + midCol + " is " + midVal + " at row " + maxRow);

            int leftNeighbor = (midCol > 0) ? mat[maxRow][midCol - 1] : -1;
            int rightNeighbor = (midCol < cols - 1) ? mat[maxRow][midCol + 1] : -1;

            System.out.println("   Left: " + leftNeighbor + ", Right: " + rightNeighbor);

            // Peak condition
            if (midVal > leftNeighbor && midVal > rightNeighbor) {
                System.out.println("Peak found at: [" + maxRow + ", " + midCol + "]");
                return new int[]{maxRow, midCol};
            }

            // Move to larger neighbor
            if (rightNeighbor > midVal) {
                System.out.println(" Move right");
                left = midCol + 1;
            } else {
                System.out.println(" Move left");
                right = midCol - 1;
            }
        }

        System.out.println(" No peak found — should not happen per constraints.");
        return new int[]{-1, -1};
    }
}
