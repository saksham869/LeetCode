import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
    
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        

        boolean[] visited = new boolean[n];
        
    
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;
        
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (node == end) return true;
            
            for (int nei : graph.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    stack.push(nei);
                }
            }
        }
        
        return false;
    }
}
