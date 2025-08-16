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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        // The first element in preorder is the root
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of the root in inorder
        int inIndex = inStart;
        while (inorder[inIndex] != rootVal) {
            inIndex++;
        }

        // Number of nodes in the left subtree
        int leftSize = inIndex - inStart;

        // Recursively build the left and right subtrees
        root.left = build(preorder, inorder, preStart + 1, preStart + leftSize, inStart, inIndex - 1);
        root.right = build(preorder, inorder, preStart + leftSize + 1, preEnd, inIndex + 1, inEnd);

        return root;
    }
}
