import java.util.*;

public class Solution {
    // Memo: key = (position, lastChar), value = list of strings
    private Map<String, List<String>> memo = new HashMap<>();

    public List<String> validStrings(int n) {
        return helper(n, '2'); // '2' means no last char yet
    }

    private List<String> helper(int n, char lastChar) {
        if (n == 0) {
            return Arrays.asList("");
        }

        String key = n + "-" + lastChar;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        List<String> result = new ArrayList<>();

        // Add '1' always
        for (String s : helper(n - 1, '1')) {
            result.add("1" + s);
        }

        // Add '0' only if lastChar != '0' (to avoid consecutive zeros)
        if (lastChar != '0') {
            for (String s : helper(n - 1, '0')) {
                result.add("0" + s);
            }
        }

        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> res = sol.validStrings(3);
        System.out.println(res);
    }
}
