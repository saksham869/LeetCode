class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // slow pointer

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;               // move slow pointer
                nums[i] = nums[j]; // overwrite duplicate
            }
        }

        return i + 1; // length = last unique index + 1
    }
}
