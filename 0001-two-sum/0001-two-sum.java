import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if complement exists in the map
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; 
            }

            // Store current number with its index
            map.put(nums[i], i);
        }
        
        return new int[]{}; // Should never be reached
    }
}
