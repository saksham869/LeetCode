class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return removeAndScore(s, 'a', 'b', x, y);
        } else {
            return removeAndScore(s, 'b', 'a', y, x);
        }
    }

    private int removeAndScore(String s, char firstChar, char secondChar, int firstScore, int secondScore) {
        StringBuilder remaining = new StringBuilder();
        int totalScore = 0;

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == firstChar && c == secondChar) {
                stack.pop();
                totalScore += firstScore;
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            remaining.append(stack.pop());
        }

        s = remaining.reverse().toString();
        stack.clear();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == secondChar && c == firstChar) {
                stack.pop();
                totalScore += secondScore;
            } else {
                stack.push(c);
            }
        }

        return totalScore;
    }
}
