public class Solution {
    public int longestPalindrome(String[] words) {
        int[][] count = new int[26][26]; // Count frequency of each two-letter word

        // Step 1: Fill the frequency matrix
        for (String word : words) {
            int first = word.charAt(0) - 'a';
            int second = word.charAt(1) - 'a';
            count[first][second]++;
        }

        int result = 0;
        boolean hasCenter = false;

        // Step 2: Handle words like "aa", "bb", etc.
        for (int i = 0; i < 26; i++) {
            if (count[i][i] % 2 == 1) {
                hasCenter = true;
            }
            result += (count[i][i] / 2) * 4;
        }

        // Step 3: Handle words like "ab" and "ba"
        for (int x = 0; x < 26; x++) {
            for (int y = x + 1; y < 26; y++) {
                int pairs = Math.min(count[x][y], count[y][x]);
                result += pairs * 4;
            }
        }

        // Step 4: If we had an unpaired palindromic word like "gg", add it in the center
        if (hasCenter) {
            result += 2;
        }

        return result;
    }
}
