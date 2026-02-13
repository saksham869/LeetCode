class Solution {
    public int findMin(int[] nums) {
      
        int n = nums.length;
        int l = 0;
        int r = n-1;
        

        while(l<r){
            int mid = l +(r-l)/2;
            if(nums[mid] >= nums[r]){
                l = mid +1;
            }else{
                r = mid;


            }
        }
        return nums[r];
        
    }
}