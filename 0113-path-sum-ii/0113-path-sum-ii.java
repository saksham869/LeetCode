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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> path, List<List<Integer>> res) {
        if (node == null) return;

        // Add current node to path
        path.add(node.val);
        targetSum -= node.val;

        // If it's a leaf and targetSum == 0, add path to result
        if (node.left == null && node.right == null && targetSum == 0) {
            res.add(new ArrayList<>(path));
        } else {
            // Explore left & right subtrees
            dfs(node.left, targetSum, path, res);
            dfs(node.right, targetSum, path, res);
        }

        // Backtrack → remove last node before going back
        path.remove(path.size() - 1);
    }
}

