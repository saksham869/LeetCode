class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int incl = nums[0]; // Max sum including the current house
        int excl = 0;       // Max sum excluding the current house

        for (int i = 1; i < nums.length; i++) {
            int newIncl = excl + nums[i];        // Rob this house
            int newExcl = Math.max(incl, excl);  // Skip this house

            incl = newIncl;
            excl = newExcl;
        }

        return Math.max(incl, excl); // Return the best of both options
    }
}
