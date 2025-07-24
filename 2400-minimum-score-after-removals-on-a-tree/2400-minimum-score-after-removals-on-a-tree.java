class Solution {
    private int[] nums;
    private List<Integer>[] tree;
    private int[] subXor;
    private Set<Integer>[] children;
    private int totalXor;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        this.nums = nums;
        this.subXor = nums.clone();
        this.tree = new List[n];
        this.children = new Set[n];
        this.totalXor = 0;
        for (int num : nums) totalXor ^= num;

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
            children[i] = new HashSet<>();
            children[i].add(i);
        }
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        dfs(0, -1);

        int minScore = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0], b = edges[i][1];
            if (children[a].contains(b)) {
                int tmp = a; a = b; b = tmp;
            }
            for (int j = 0; j < i; j++) {
                int c = edges[j][0], d = edges[j][1];
                if (children[c].contains(d)) {
                    int tmp = c; c = d; d = tmp;
                }

                int[] values;
                if (children[a].contains(c) && a != c) {
                    values = new int[]{subXor[c], subXor[a] ^ subXor[c], totalXor ^ subXor[a]};
                } else if (children[c].contains(a) && a != c) {
                    values = new int[]{subXor[a], subXor[c] ^ subXor[a], totalXor ^ subXor[c]};
                } else {
                    values = new int[]{subXor[a], subXor[c], totalXor ^ subXor[a] ^ subXor[c]};
                }
                int maxV = Math.max(values[0], Math.max(values[1], values[2]));
                int minV = Math.min(values[0], Math.min(values[1], values[2]));
                minScore = Math.min(minScore, maxV - minV);
            }
        }
        return minScore;
    }

    private Pair<Integer, Set<Integer>> dfs(int u, int parent) {
        for (int v : tree[u]) {
            if (v == parent) continue;
            Pair<Integer, Set<Integer>> result = dfs(v, u);
            subXor[u] ^= result.getKey();
            children[u].addAll(result.getValue());
        }
        return new Pair<>(subXor[u], children[u]);
    }
}
