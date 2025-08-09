public class Solution {
    public static boolean isPowerOfTwo(int n) {
        if (n == 1) return true;   // Base case: 3^0 = 1 is a power of three
        if (n <= 0 || n % 2 != 0) return false; // Negative and non-multiples of 3 are false
        
        return isPowerOfTwo(n / 2); // Recursive call
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(24)) ; // Output: true
        System.out.println(isPowerOfTwo(6));   // Output: true
        System.out.println(isPowerOfTwo(10));  // Output: false
        System.out.println(isPowerOfTwo(1));   // Output: true
        System.out.println(isPowerOfTwo(0));   // Output: false
        System.out.println(isPowerOfTwo(-3));  // Output: false
    }
}
