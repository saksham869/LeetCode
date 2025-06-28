class Solution {
    public int splitArray(int[] nums, int k) {
        int start = getMax(nums);   // Smallest possible max sum
        int end = getSum(nums);     // Largest possible max sum

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (canSplit(nums, k, mid)) {
                end = mid; // Try smaller
            } else {
                start = mid + 1; // Need to allow larger sum
            }
        }

        return start; // or end
    }

    private boolean canSplit(int[] nums, int k, int maxAllowed) {
        int count = 1;
        int sum = 0;

        for (int num : nums) {
            if (sum + num <= maxAllowed) {
                sum += num;
            } else {
                count++;
                sum = num;
                if (count > k) return false;
            }
        }

        return true;
    }

    private int getSum(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;
        return total;
    }

    private int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) max = Math.max(max, num);
        return max;
    }
}
