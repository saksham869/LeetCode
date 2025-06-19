class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 1;
        int minVal = nums[0];
        
        for (int x : nums) {
            if (x - minVal > k) {
                count++;
                minVal = x;
            }
        }
        return count;
    }
}
