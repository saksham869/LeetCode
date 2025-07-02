class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int possibleStringCount(String word, int k) {
        List<Integer> groups = getConsecutiveGroups(word);
        
        // Calculate total combinations (product of group sizes)
        long total = 1;
        for (int g : groups) {
            total = (total * g) % MOD;
        }
        // If minimum length k is already satisfied by group count, return total
        if (k <= groups.size()) return (int) total;

        // Count ways that result in strings shorter than k
        int need = k;
        int[] dp = new int[need];
        dp[0] = 1; // There's one way to form an empty string

        for (int i = 0; i < groups.size(); i++) {
            int g = groups.get(i);
            int[] newDp = new int[need];
            long windowSum = 0;
            // Sliding window prefix sum to speed up dp transitions
            for (int j = i; j < need; j++) {
                newDp[j] = (int) ((newDp[j] + windowSum) % MOD);
                windowSum = (windowSum + dp[j]) % MOD;
                if (j >= g) {
                    windowSum = (windowSum - dp[j - g] + MOD) % MOD;
                }
            }
            dp = newDp;
        }

        // Sum of dp counts invalid (< k) results
        long invalid = 0;
        for (int x : dp) invalid = (invalid + x) % MOD;
        // Subtract and fix modulo
        return (int) ((total - invalid + MOD) % MOD);
    }

    // Helper: Converts string into lengths of consecutive identical characters
    private List<Integer> getConsecutiveGroups(String s) {
        List<Integer> groups = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) count++;
            else {
                groups.add(count);
                count = 1;
            }
        }
        groups.add(count);
        return groups;
    }
}
