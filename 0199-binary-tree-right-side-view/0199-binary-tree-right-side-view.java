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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size(); // number of nodes at this level

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // Add children to queue
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);

                // If it's the last node of this level → rightmost
                if(i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
