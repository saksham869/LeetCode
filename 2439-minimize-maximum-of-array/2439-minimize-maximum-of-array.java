class Solution {
    public int minimizeArrayValue(int[] nums) {
        int l = 0;
        int h = 0;
        for(int num : nums){
            h = Math.max(h , num);

        }
        while(l <= h){
            int mid =  l+(h-l)/2;
            if(isPossible(nums , mid)){
                h = mid - 1;

            }else{
                l = mid + 1;
            }
        }
        return l;

        
    }
    private boolean isPossible(int nums[], int maxAllowed){
        long carry = 0;
        for(int i = nums.length-1; i > 0; i--){
            long current = nums[i] + carry;
            if (current > maxAllowed){
                carry = current - maxAllowed;
            }else{
                carry= 0;

            }

        }

        return  nums[0] + carry <= maxAllowed;
    }
}