class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int num = Math.abs(nums[i]);   
            int index = num - 1;          

            if (nums[index] < 0) {
                result.add(num);
            } else {
                nums[index] = -nums[index];
            }
        }

        return result;
    }
}
