import java.util.*;

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        
        // Get the count of unique elements
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }
        int c = st.size();

        int i = 0, j = 0, res = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        while (j < n) {
            // Add nums[j] to the map and update its count
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);

            // While the current window contains all distinct elements
            while (mp.size() == c) {
                // Add the number of valid subarrays starting at i and ending at j
                res += (n - j);

                // Shrink the window from the left
                mp.put(nums[i], mp.get(nums[i]) - 1);
                if (mp.get(nums[i]) == 0) {
                    mp.remove(nums[i]);
                }
                i++;
            }
            j++;
        }

        return res;
    }
}
