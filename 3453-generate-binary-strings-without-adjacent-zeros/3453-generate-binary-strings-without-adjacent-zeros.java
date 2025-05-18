import java.util.*;

public class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        generateStrings("", n, result);
        return result;
    }
    
    private void generateStrings(String prefix, int n, List<String> result) {
        if (prefix.length() == n) {
            result.add(prefix);
            return;
        }
        
        // Add '1' always
        generateStrings(prefix + "1", n, result);
        
        // Add '0' only if last char is not '0' (to avoid consecutive zeros)
        if (prefix.isEmpty() || prefix.charAt(prefix.length() - 1) != '0') {
            generateStrings(prefix + "0", n, result);
        }
    }
    
    // For quick testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> res = sol.validStrings(3);
        System.out.println(res);
    }
}
