import java.util.*;

class Solution {
    public int maxSum(int[] nums) {
        int mx = Arrays.stream(nums).max().getAsInt();
        if (mx <= 0) {
            return mx;
        }
        Set<Integer> unique = new HashSet<>();
        int sum = 0;
        for (int num : nums) {
            if (num > 0 && unique.add(num)) {
                sum += num;
            }
        }
        return sum;
    }
}
