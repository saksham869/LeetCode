class Solution {
    public boolean canJump(int[] nums) {
        int FinalPosition =nums.length-1;


        for(int i=nums.length-2;i>=0;i--){
            if(i + nums[i]>=FinalPosition){
                FinalPosition = i;

            }

        }
        return FinalPosition == 0;

        
    }
}