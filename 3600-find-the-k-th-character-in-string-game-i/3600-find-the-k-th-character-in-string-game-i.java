class Solution {
    public char kthCharacter(int k) {
        // count 1-bits in (k - 1)
        int ones = Integer.bitCount(k - 1);
        return (char) ('a' + ones);
    }
}
