public class Solution {
    public List<List<Integer>> fourSum(int[] nums, long target) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Sort the array to apply two-pointer technique
        Arrays.sort(nums);
        
        // Traverse the array with the first element
        for (int i = 0; i < nums.length - 3; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            // Traverse the array with the second element
            for (int j = i + 1; j < nums.length - 2; j++) {
                // Skip duplicates for the second element
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                int left = j + 1;  // Pointer for the third element
                int right = nums.length - 1;  // Pointer for the fourth element
                
                // Use two-pointer technique for the third and fourth elements
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // Skip duplicates for the third element
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        // Skip duplicates for the fourth element
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case with large numbers
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        long target = 4000000000L;  // Use long for the target
        System.out.println(solution.fourSum(nums, target)); // Expected output: [[1000000000, 1000000000, 1000000000, 1000000000]]
    }
}
