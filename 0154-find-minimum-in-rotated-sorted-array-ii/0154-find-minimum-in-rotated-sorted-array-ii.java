class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If right half is sorted, or min is at mid or left side
            if (nums[mid] < nums[high]) {
                high = mid;
            }
            // If left half is sorted, min must be in right half
            else if (nums[mid] > nums[high]) {
                low = mid + 1;
            }
            // When nums[mid] == nums[high], we can't tell — reduce high
            else {
                high--;
            }
        }

        return nums[low]; // or nums[high]
    }
}
