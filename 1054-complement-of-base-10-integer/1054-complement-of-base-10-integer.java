public class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;  // Special case

        int mask = 0;
        int temp = n;

        // Create a mask with all bits set to 1 up to the highest bit in n
        while (temp > 0) {
            mask = (mask << 1) | 1;
            temp >>= 1;
        }

        return n ^ mask;  // XOR with the mask to flip the bits
    }
}

