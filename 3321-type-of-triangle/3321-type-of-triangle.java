class Solution {
    public String triangleType(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        // Check for triangle validity
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "none";
        }

        // Check for triangle type
        if (a == b && b == c) {
            return "equilateral";
        } else if (a == b || a == c || b == c) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}
