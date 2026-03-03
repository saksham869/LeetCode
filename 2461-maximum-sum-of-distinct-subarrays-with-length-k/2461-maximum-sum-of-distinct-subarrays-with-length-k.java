import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        long currentSum = 0;
        long maxSum = 0;
        
        int left = 0;
        
        for (int right = 0; right < nums.length; right++) {
            
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            currentSum += nums[right];
            
            if (right - left + 1 > k) {
                
                map.put(nums[left], map.get(nums[left]) - 1);
                
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                
                currentSum -= nums[left];
                left++;
            }
            
            if (right - left + 1 == k && map.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        
        return maxSum;
    }
}