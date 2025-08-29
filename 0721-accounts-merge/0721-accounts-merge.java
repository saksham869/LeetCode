class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        Map<String, Integer> emailToIndex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        // Union emails
        for (int i = 0; i < n; i++) {
            List<String> acc = accounts.get(i);
            String name = acc.get(0);
            for (int j = 1; j < acc.size(); j++) {
                String email = acc.get(j);
                emailToName.put(email, name);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, i);
                } else {
                    union(parent, i, emailToIndex.get(email));
                }
            }
        }

        // Group emails by root parent
        Map<Integer, TreeSet<String>> groups = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int root = find(parent, emailToIndex.get(email));
            groups.computeIfAbsent(root, k -> new TreeSet<>()).add(email);
        }

        // Format result
        List<List<String>> res = new ArrayList<>();
        for (var entry : groups.entrySet()) {
            String name = emailToName.get(entry.getValue().first());
            List<String> merged = new ArrayList<>(entry.getValue());
            merged.add(0, name);
            res.add(merged);
        }

        return res;
    }

    private int find(int[] parent, int x) {
        return parent[x] == x ? x : (parent[x] = find(parent, parent[x]));
    }

    private void union(int[] parent, int x, int y) {
        parent[find(parent, x)] = find(parent, y);
    }
}
