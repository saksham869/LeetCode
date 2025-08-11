class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int[] productQueries(int n, int[][] queries) {
        // Step 1: Extract powers of 2 from n (i.e., set bits)
        List<Integer> powers = new ArrayList<>();
        for (int bit = 0; n > 0; ++bit) {
            int x = n & -n; // lowest set bit
            powers.add(x);
            n -= x;
        }

        int m = powers.size();
        // Step 2: Build prefix product array (modulo)
        long[] prefix = new long[m + 1];
        prefix[0] = 1;
        for (int i = 0; i < m; i++) {
            prefix[i + 1] = prefix[i] * powers.get(i) % MOD;
        }

        // Step 3: Answer queries using modular inverses
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            long prod = prefix[r + 1] * modInverse(prefix[l]) % MOD;
            result[i] = (int) prod;
        }

        return result;
    }

    // Fast exponentiation to compute modular inverse
    private long modInverse(long a) {
        long res = 1, p = MOD - 2;
        long base = a % MOD;
        while (p > 0) {
            if ((p & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            p >>= 1;
        }
        return res;
    }
}
