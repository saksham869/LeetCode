import java.util.*;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        int sum = 0, count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {

            sum += num;

            int mod = sum % k;


            if (mod < 0) mod += k;

            if (map.containsKey(mod)) {
                count += map.get(mod);
            }

            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }

        return count;
    }
}