class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }

            // Identify the sorted half
            if (nums[left] <= nums[mid]) { // Left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;  // Search in left half
                } else {
                    left = mid + 1;   // Search in right half
                }
            } else {  // Right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;  // Search in right half
                } else {
                    right = mid - 1; // Search in left half
                }
            }
        }
        
        return -1; // Target not found
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        
        int result = solution.search(nums, target);
        System.out.println("Target index: " + result); // Output: 4
    }
}