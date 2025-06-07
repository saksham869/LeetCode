class Solution {
    public String clearStars(String s) {
        int n = s.length();
        @SuppressWarnings("unchecked")
        Deque<Integer>[] buckets = new Deque[26];
        for (int i = 0; i < 26; i++) {
            buckets[i] = new ArrayDeque<>();
        }

        boolean[] toRemove = new boolean[n];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                toRemove[i] = true;
                // Find smallest letter on the left
                for (int j = 0; j < 26; j++) {
                    if (!buckets[j].isEmpty()) {
                        toRemove[buckets[j].pop()] = true;
                        break;
                    }
                }
            } else {
                buckets[c - 'a'].push(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!toRemove[i]) sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
