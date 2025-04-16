import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long ans = 0;
        long pairs = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int count = freq.getOrDefault(nums[right], 0);
            pairs += count;
            freq.put(nums[right], count + 1);

            while (pairs >= k) {
                ans += nums.length - right;
                int leftCount = freq.get(nums[left]);
                freq.put(nums[left], leftCount - 1);
                pairs -= leftCount - 1;
                left++;
            }
        }

        return ans;
    }
}
