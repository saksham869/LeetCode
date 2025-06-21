import java.util.*;

class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        Arrays.sort(freq);

        int n = word.length();
        int ans = n;

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;

            int deletions = 0;

            // Remove all chars with frequency less than freq[i]
            for (int j = 0; j < i; j++) {
                deletions += freq[j];
            }

            // Trim down characters with frequency > freq[i] + k
            for (int j = i + 1; j < 26; j++) {
                if (freq[j] > freq[i] + k) {
                    deletions += freq[j] - (freq[i] + k);
                }
            }

            ans = Math.min(ans, deletions);
        }

        return ans;
    }
}
