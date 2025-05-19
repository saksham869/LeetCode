class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // Rob from 0 to n-2
        int option1 = robLinear(nums, 0, n - 2);
        // Rob from 1 to n-1
        int option2 = robLinear(nums, 1, n - 1);
        
        return Math.max(option1, option2);
    }

    // Helper function (same as House Robber I)
    private int robLinear(int[] nums, int start, int end) {
        int incl = 0, excl = 0;

        for (int i = start; i <= end; i++) {
            int newIncl = excl + nums[i];
            int newExcl = Math.max(incl, excl);

            incl = newIncl;
            excl = newExcl;
        }

        return Math.max(incl, excl);
    }
}
