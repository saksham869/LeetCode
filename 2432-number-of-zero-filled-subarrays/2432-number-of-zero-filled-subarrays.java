class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long cnt = 0;   
        
        for (int v : nums) {
            if (v == 0) {
                cnt++;       
                ans += cnt;   
            } else {
                cnt = 0;      
            }
        }
        return ans;
    }
}
