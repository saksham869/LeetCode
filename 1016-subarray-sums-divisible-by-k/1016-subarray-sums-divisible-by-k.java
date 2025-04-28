class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k];
        count[0] = 1; // For the empty prefix sum
        int sum = 0, ans = 0;
        
        for (int num : nums) {
            sum += num;
            int mod = (sum % k + k) % k; // Always keep mod positive
            
            ans += count[mod];
            count[mod]++;
        }
        
        return ans;
    }
}
