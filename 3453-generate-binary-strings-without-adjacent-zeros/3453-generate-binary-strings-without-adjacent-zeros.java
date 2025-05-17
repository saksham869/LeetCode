import java.util.*;

public class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        generate(n, "", result);
        return result;
    }

    private void generate(int n, String current, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }

        // Always add '1'
        generate(n, current + "1", result);

        // Add '0' only if the last character is not '0'
        if (current.isEmpty() || current.charAt(current.length() - 1) != '0') {
            generate(n, current + "0", result);
        }
    }
}
