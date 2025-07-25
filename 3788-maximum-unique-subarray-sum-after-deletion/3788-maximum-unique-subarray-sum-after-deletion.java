class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int sum = nums[0];
        int max = nums[0];
        set.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(!set.contains(nums[i])){
                if(sum <= 0 && nums[i] > 0){
                    sum = nums[i];
                    max = Math.max(sum, max);
                    set.add(nums[i]);
                }
                else if(nums[i] > 0){
                    sum += nums[i];
                    max = Math.max(sum,max);
                    set.add(nums[i]);
                }else{
                    max = Math.max(max, nums[i]);
                    set.add(nums[i]);
                }
            }
        }
        return max;
    }
}