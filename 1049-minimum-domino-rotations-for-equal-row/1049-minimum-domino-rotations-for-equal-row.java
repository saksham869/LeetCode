public class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        // Try all possible values from 1 to 6
        for (int target = 1; target <= 6; target++) {
            int rotationsA = 0, rotationsB = 0, rotationsBoth = 0;
            boolean possible = true;

            // Check all dominos
            for (int i = 0; i < A.length; i++) {
                if (A[i] != target && B[i] != target) {
                    possible = false;
                    break;
                }
                if (A[i] != target) rotationsA++; // Need to rotate the top row domino
                if (B[i] != target) rotationsB++; // Need to rotate the bottom row domino
            }

            if (possible) {
                // The result is the minimum rotations needed
                return Math.min(rotationsA, rotationsB);
            }
        }
        return -1; // It's not possible to make all values the same
    }
}
