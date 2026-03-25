class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for(int num : nums){
            totalSum +=num;
        }
        int left  = 0;
        for(int i = 0; i<nums.length; i++){
            int rightSum = totalSum -left - nums[i];
            if(left == rightSum){
                return i ;
            }
            left += nums[i];
        }
        return -1;

        
    }
}