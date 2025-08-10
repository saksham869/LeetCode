class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] countN = countDigits(n);
        for (int i = 0; i < 31; i++) {
            if (Arrays.equals(countN, countDigits(1 << i))) {
                return true;
            }
        }
        return false;
    }

    private int[] countDigits(int x) {
        int[] cnt = new int[10];
        while (x > 0) {
            cnt[x % 10]++;
            x /= 10;
        }
        return cnt;
    }
}
