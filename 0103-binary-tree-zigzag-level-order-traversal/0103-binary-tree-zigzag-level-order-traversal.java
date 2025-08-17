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
import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (leftToRight) {
                    level.addLast(node.val);   // normal order
                } else {
                    level.addFirst(node.val);  // reverse order
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            res.add(new ArrayList<>(level));
            leftToRight = !leftToRight; // flip direction
        }

        return res;
    }
}


//2nd 
// public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//     List<List<Integer>> res = new LinkedList<>();
//     if (root == null) return res;

//     Queue<TreeNode> queue = new LinkedList<>();
//     queue.offer(root);
//     int level = 0;

//     while (!queue.isEmpty()) {
//         int size = queue.size();
//         List<Integer> levelSubList = new LinkedList<>();

//         while (size > 0) {
//             TreeNode node = queue.poll();

//             // if odd level -> insert at front
//             if (level % 2 != 0)
//                 levelSubList.add(0, node.val);  // addFirst
//             else
//                 levelSubList.add(node.val);

//             if (node.left != null) queue.offer(node.left);
//             if (node.right != null) queue.offer(node.right);

//             size--;
//         }

//         res.add(levelSubList);
//         level++;  // next level
//     }
//     return res;
// }
