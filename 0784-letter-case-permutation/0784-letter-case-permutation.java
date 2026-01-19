import java.util.*;

class Solution {

    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        backtrack(chars, 0, result);
        return result;
    }

    private void backtrack(char[] chars, int index, List<String> result) {

        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }

        if (Character.isDigit(chars[index])) {
            backtrack(chars, index + 1, result);
        } 
        else {
            chars[index] = Character.toLowerCase(chars[index]);
            backtrack(chars, index + 1, result);

            chars[index] = Character.toUpperCase(chars[index]);
            backtrack(chars, index + 1, result);
        }
    }
}
