/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        dfs(root);
        return maxDiameter;
    }

    // Returns the height of the subtree rooted at 'node'
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);

        // Update diameter: longest path that goes through this node
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return height — add 1 to count current node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

