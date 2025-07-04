class Solution {
    public char kthCharacter(long k, int[] operations) {
        int ops = (int) Math.ceil(Math.log(k) / Math.log(2));
        int increments = 0;

        for (int i = ops - 1; i >= 0; --i) {
            long half = 1L << i;
            if (k > half) {
                k -= half;
                increments += operations[i];
            }
        }
        return (char) ('a' + (increments % 26));
    }
}
