/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *   int val;
 *   TreeNode left;
 *   TreeNode right;
 *   TreeNode(int val) { this.val = val; }
 * }
 */

class Solution {
    private int moves = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftBalance = dfs(node.left);
        int rightBalance = dfs(node.right);

        // Moves needed to satisfy children
        moves += Math.abs(leftBalance) + Math.abs(rightBalance);

        // Current balance: extra or deficit coins for this subtree
        return node.val - 1 + leftBalance + rightBalance;
    }
}
