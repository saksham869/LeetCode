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

// class Solution {
//     public int minDepth(TreeNode root) {
//         if (root == null) return 0;

//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);

//         int depth = 1;

//         while (!queue.isEmpty()) {
//             int size = queue.size();

//             for (int i = 0; i < size; i++) {
//                 TreeNode node = queue.poll();

//                 if (node.left == null && node.right == null) {
//                     return depth;
//                 }

//                 if (node.left != null) queue.add(node.left);
//                 if (node.right != null) queue.add(node.right);
//             }

//             depth++;
//         }

//         return depth;
//     }
// }
class Solution{
    public int minDepth(TreeNode root){
        if(root == null){
            return 0;

        }
        if(root.left == null && root.right == null){
            return 1;

        }
        if(root.left == null){
            return 1+ minDepth(root.right);
        }
        if(root.right == null){
            return 1+ minDepth(root.left);
        }
        return 1+ Math.min(minDepth(root.left),minDepth(root.right));

        
    }
}