// class Solution {
//     public int strStr(String haystack, String needle) {
//         if (needle == null || needle.length() == 0) {
//             return 0;
//         }
//         if (haystack == null) {
//             return -1;
//         }

//         int n = haystack.length();
//         int m = needle.length();
//         if (m > n) {
//             return -1;
//         }

//         for (int i = 0; i <= n - m; i++) {
//             if (haystack.substring(i, i + m).equals(needle)) {
//                 return i;
//             }
//         }
//         return -1;
//     }
// }


import java.util.regex.*;

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) return 0;
        if (haystack == null || haystack.isEmpty()) return -1;

        Pattern pattern = Pattern.compile(Pattern.quote(needle));
        Matcher matcher = pattern.matcher(haystack);

        if (matcher.find()) {
            return matcher.start();
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strStr("hello", "ll"));
        System.out.println(s.strStr("mississippi", "issip"));
        System.out.println(s.strStr("abc", "d"));
    }
}

