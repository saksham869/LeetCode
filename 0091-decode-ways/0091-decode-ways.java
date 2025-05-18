public class Solution{
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int n = s.length();
        int[] dp = new int[n];

        // Base case
        dp[0] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 1; i < n; i++) {
            char curr = s.charAt(i);
            char prev = s.charAt(i - 1);

            // Case 1: both current and previous are '0' => invalid
            if (prev == '0' && curr == '0') {
                dp[i] = 0;
            }

            // Case 2: previous is '0', current is valid
            else if (prev == '0') {
                dp[i] = dp[i - 1];
            }

            // Case 3: current is '0', check valid 10 or 20
            else if (curr == '0') {
                if (prev == '1' || prev == '2') {
                    dp[i] = i >= 2 ? dp[i - 2] : 1;
                } else {
                    dp[i] = 0;
                }
            }

            // Case 4: both characters form a number ≤ 26
            else {
                int val = Integer.parseInt(s.substring(i - 1, i + 1));
                if (val <= 26) {
                    dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }

        return dp[n - 1];
    }
}
