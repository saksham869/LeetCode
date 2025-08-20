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

    private int cameraCount = 0; // global counter for cameras

    public int minCameraCover(TreeNode root) {
        // run DFS from root
        // if root itself needs coverage (returns 0), we must place one more camera
        if (dfs(root) == 0) {
            cameraCount++;
        }
        return cameraCount;
    }

    /**
     * DFS function returns the state of a node:
     * 0 -> this node needs coverage
     * 1 -> this node is covered by a child camera
     * 2 -> this node has a camera
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 1; // null nodes are treated as "covered"
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        // Rule #1: If any child needs coverage → place camera here
        if (left == 0 || right == 0) {
            cameraCount++;
            return 2; // this node has a camera
        }

        // Rule #2: If any child has a camera → this node is covered
        if (left == 2 || right == 2) {
            return 1; // covered without camera
        }

        // Rule #3: Otherwise → this node needs coverage
        return 0;
    }
}
