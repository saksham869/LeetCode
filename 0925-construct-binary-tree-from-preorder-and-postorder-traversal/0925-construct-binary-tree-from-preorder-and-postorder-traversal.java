import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { this.val = val; }
 * }
 */
class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> postIndex = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postIndex.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1, postIndex);
    }

    private TreeNode build(int[] pre, int preStart, int preEnd,
                           int[] post, int postStart, int postEnd,
                           Map<Integer, Integer> postIndex) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd) {
            return root;
        }
        int leftRootVal = pre[preStart + 1];
        int leftRootPostIndex = postIndex.get(leftRootVal);
        int leftSize = leftRootPostIndex - postStart + 1;

        root.left = build(pre, preStart + 1, preStart + leftSize, post, postStart, leftRootPostIndex, postIndex);
        root.right = build(pre, preStart + leftSize + 1, preEnd, post, leftRootPostIndex + 1, postEnd - 1, postIndex);

        return root;
    }
}
