class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        return dfs(0, -1, graph, hasApple);
    }

    private int dfs(int u, int parent, List<Integer>[] graph, List<Boolean> hasApple) {
        int total = 0;
        for (int v : graph[u]) {
            if (v == parent) continue;
            int cost = dfs(v, u, graph, hasApple);
            if (cost > 0 || hasApple.get(v)) {
                total += cost + 2;
            }
        }
        return total;
    }
}
