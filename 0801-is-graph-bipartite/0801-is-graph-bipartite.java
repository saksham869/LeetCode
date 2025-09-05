class Solution {
    public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] color = new int[n];
    Arrays.fill(color, 0); // 0: uncolored, 1 and -1: two colors

    for (int i = 0; i < n; i++) {
        if (color[i] != 0) continue;
        color[i] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph[u]) {
                if (color[v] == color[u]) return false;
                if (color[v] == 0) {
                    color[v] = -color[u];
                    queue.add(v);
                }
            }
        }
    }
    return true;

    }
   
}