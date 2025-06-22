class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid % 2 == 1) 
                mid--;  // ensure we compare the start of a pair
            
            // Check pair alignment
            if (nums[mid] == nums[mid + 1])
                low = mid + 2;  // single element is further right
            else
                high = mid;     // single element is at mid or left
        }
        return nums[low];
    }
}
