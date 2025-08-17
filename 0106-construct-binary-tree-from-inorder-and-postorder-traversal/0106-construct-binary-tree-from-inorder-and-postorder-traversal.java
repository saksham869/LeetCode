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
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int inStart, int inEnd) {
        // 1. Base Case: no elements to construct
        if (inStart > inEnd) return null;

        // 2. Root is last in postorder
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // 3. If it's a leaf node (single element), no need to recurse further
        if (inStart == inEnd) return root;

        // 4. Find root's index in inorder to split subtrees
        int inIndex = inorderIndexMap.get(rootVal);

        // 5. Build right subtree first (because in postorder we process right just before root)
        root.right = build(inorder, postorder, inIndex + 1, inEnd);
        // 6. Then build left subtree
        root.left  = build(inorder, postorder, inStart, inIndex - 1);

        return root;
    }
}
