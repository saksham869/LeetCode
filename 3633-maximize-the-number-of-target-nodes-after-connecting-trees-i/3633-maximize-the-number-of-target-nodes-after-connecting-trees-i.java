import java.util.*;

public class Solution {
    static class Pair {
        int node, parent;
        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    private int bfs(List<List<Integer>> adj, int start, int k) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(start, -1));
        int count = 0;

        while (!queue.isEmpty() && k >= 0) {
            int size = queue.size();
            count += size;
            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                int u = current.node;
                int parent = current.parent;
                for (int v : adj.get(u)) {
                    if (v != parent) {
                        queue.offer(new Pair(v, u));
                    }
                }
            }
            k--;
        }
        return count;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> adj1 = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < n; i++) adj1.add(new ArrayList<>());
        for (int i = 0; i < m; i++) adj2.add(new ArrayList<>());

        for (int[] edge : edges1) {
            adj1.get(edge[0]).add(edge[1]);
            adj1.get(edge[1]).add(edge[0]);
        }

        for (int[] edge : edges2) {
            adj2.get(edge[0]).add(edge[1]);
            adj2.get(edge[1]).add(edge[0]);
        }

        int maxSecondTree = 0;
        if (k > 0) {
            for (int i = 0; i < m; i++) {
                maxSecondTree = Math.max(maxSecondTree, bfs(adj2, i, k - 1));
            }
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int count = bfs(adj1, i, k);
            result[i] = count + maxSecondTree;
        }

        return result;
    }
}
