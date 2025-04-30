class Solution {
    static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        // Convert int[] to List<Integer>
        List<Integer> bList = new ArrayList<>();
        for (int digit : b) {
            bList.add(digit);
        }
        return helper(a, bList);
    }

    private int helper(int a, List<Integer> b) {
        if (b.isEmpty()) return 1;

        int lastDigit = b.remove(b.size() - 1);
        int part1 = modPow(helper(a, b), 10);
        int part2 = modPow(a, lastDigit);

        return (part1 * part2) % MOD;
    }

    private int modPow(int a, int k) {
        a %= MOD;
        int result = 1;
        for (int i = 0; i < k; i++) {
            result = (result * a) % MOD;
        }
        return result;
    }
}
