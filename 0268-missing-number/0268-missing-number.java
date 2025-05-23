public class Solution {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;  // Sum of numbers from 0 to n
        int actualSum = 0;
        
        for (int num : nums) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;  // Missing number
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 0, 1};
        System.out.println(missingNumber(nums1)); // Output: 2

        int[] nums2 = {0, 1};
        System.out.println(missingNumber(nums2)); // Output: 2

        int[] nums3 = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums3)); // Output: 8
    }
}
