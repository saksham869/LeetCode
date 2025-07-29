class Solution {
    public int[] smallestSubarrays(int[] nums) {
        final int kMaxBit = 30;
        int[] ans = new int[nums.length];
        int[] last = new int[kMaxBit];
        java.util.Arrays.fill(ans, 1);
        // last[j] = latest position where bit j was 1
        for (int i = nums.length - 1; i >= 0; --i) {
            for (int j = 0; j < kMaxBit; ++j) {
                if (((nums[i] >> j) & 1) == 1) {
                    last[j] = i;
                }
            }
            int maxLen = 1;
            for (int j = 0; j < kMaxBit; ++j) {
                if (last[j] != 0) {
                    maxLen = Math.max(maxLen, last[j] - i + 1);
                }
            }
            ans[i] = maxLen;
        }
        return ans;
    }
}
