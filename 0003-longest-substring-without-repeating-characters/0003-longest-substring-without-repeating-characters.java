

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb")); // Output: 3
        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));    // Output: 1
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));   // Output: 3
        System.out.println(sol.lengthOfLongestSubstring(""));         // Output: 0
        System.out.println(sol.lengthOfLongestSubstring("dvdf"));     // Output: 3
    }
}
