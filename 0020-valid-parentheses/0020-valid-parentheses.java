import java.util.*;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (char c : s.toCharArray()) {

            // If closing bracket
            if (map.containsKey(c)) {

                char top = stack.isEmpty() ? '#' : stack.pop();

                if (top != map.get(c)) {
                    return false;
                }

            } else {
                // Opening bracket
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
