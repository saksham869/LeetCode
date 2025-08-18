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
    // Helper to carry node with its (row, col)
    static class NodeInfo {
        TreeNode node;
        int row, col;
        NodeInfo(TreeNode n, int r, int c) {
            node = n; row = r; col = c;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // col -> (row -> min-heap of values)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> colMap = new TreeMap<>();

        // Standard BFS with coordinates
        Queue<NodeInfo> q = new LinkedList<>();
        q.offer(new NodeInfo(root, 0, 0));

        while (!q.isEmpty()) {
            NodeInfo cur = q.poll();
            TreeNode node = cur.node;
            int r = cur.row, c = cur.col;

            colMap
                .computeIfAbsent(c, k -> new TreeMap<>())
                .computeIfAbsent(r, k -> new PriorityQueue<>())
                .offer(node.val);

            if (node.left  != null) q.offer(new NodeInfo(node.left,  r + 1, c - 1));
            if (node.right != null) q.offer(new NodeInfo(node.right, r + 1, c + 1));
        }

        // Build result: columns left→right, rows top→bottom, values ascending on ties
        for (TreeMap<Integer, PriorityQueue<Integer>> rowMap : colMap.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : rowMap.values()) {
                while (!pq.isEmpty()) colList.add(pq.poll());
            }
            result.add(colList);
        }

        return result;
    }
}
