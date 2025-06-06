class Solution {
    public String robotWithString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        char minChar = 'a';

        for (char c : s.toCharArray()) {
            stack.push(c);
            count[c - 'a']--;

            while (minChar <= 'z' && count[minChar - 'a'] == 0) {
                minChar++;
            }

            while (!stack.isEmpty() && stack.peek() <= minChar) {
                result.append(stack.pop());
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
