public class Solution {
    public static boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));  // Output: true
        System.out.println(isPowerOfThree(9));   // Output: true
        System.out.println(isPowerOfThree(10));  // Output: false
    }
}
