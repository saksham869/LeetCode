class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0; // Pointer for the position to place the next non-zero element

        // Move all non-zero elements to the front
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                // Swap non-zero element with left pointer
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++; // Move left pointer ahead
            }
        }
    }
}
