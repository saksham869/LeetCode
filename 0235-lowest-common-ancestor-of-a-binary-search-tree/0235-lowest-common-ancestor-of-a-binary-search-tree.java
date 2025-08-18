/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val; TreeNode left, right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int r = root.val, pv = p.val, qv = q.val;
        if (pv > r && qv > r)       return lowestCommonAncestor(root.right, p, q);
        else if (pv < r && qv < r)  return lowestCommonAncestor(root.left, p, q);
        else                         return root;  // split point
    }
}

