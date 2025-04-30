class Solution {
    public int findNumbers(int[] nums) {
        int count = 0; // to count numbers with even number of digits
        for (int i = 0; i < nums.length; i++) {
            int digits = 0;
            int num = nums[i];

            while (num != 0) {
                digits++;
                num /= 10;
            }

            if (digits % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
