class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        return Math.max(
            robTab(nums, 0, n - 2),
            robTab(nums, 1, n - 1)
        );
    }

    private int robTab(int[] nums, int start, int end) {
        int len = end - start + 1;
        int[] dp = new int[len];

        dp[0] = nums[start];

        if (len > 1) {
            dp[1] = Math.max(nums[start], nums[start + 1]);
        }

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(
                dp[i - 1],
                nums[start + i] + dp[i - 2]
            );
        }

        return dp[len - 1];
    }
}