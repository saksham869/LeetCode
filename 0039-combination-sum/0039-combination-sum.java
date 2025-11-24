import java.util.*;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remain, int start,
                           List<Integer> path, List<List<Integer>> result) {

        if (remain == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (remain < 0) return;

        for (int i = start; i < candidates.length; i++) {

            int candidate = candidates[i];
            if (candidate > remain) break;

            path.add(candidate);
            backtrack(candidates, remain - candidate, i, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combos = sol.combinationSum(candidates, target);
        System.out.println(combos);
    }
}
