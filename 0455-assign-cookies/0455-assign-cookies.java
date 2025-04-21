import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // Sort greed array
        Arrays.sort(s); // Sort cookie sizes

        int i = 0; // Pointer for children
        int j = 0; // Pointer for cookies
        int count=0;


        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                // Cookie is enough for child
                count++;

                i++; // Move to next child
            }
            j++; // Try next cookie
        }

        return i; // Number of satisfied children
    }
}
