class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        // Map each number to its index in nums2
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[nums2[i]] = i;
        }

        // Transform nums1 based on positions in nums2
        int[] transformed = new int[n];
        for (int i = 0; i < n; i++) {
            transformed[i] = pos[nums1[i]];
        }

        // Count of smaller elements before current index
        long[] leftSmaller = new long[n];
        BIT bit1 = new BIT(n);
        for (int i = 0; i < n; i++) {
            leftSmaller[i] = bit1.query(transformed[i]);
            bit1.update(transformed[i] + 1, 1);
        }

        // Count of larger elements after current index
        long result = 0;
        BIT bit2 = new BIT(n);
        for (int i = n - 1; i >= 0; i--) {
            long rightLarger = bit2.query(n) - bit2.query(transformed[i] + 1);
            result += leftSmaller[i] * rightLarger;
            bit2.update(transformed[i] + 1, 1);
        }

        return result;
    }

    class BIT {
        long[] tree;
        int n;

        public BIT(int size) {
            n = size + 2;
            tree = new long[n];
        }

        public void update(int i, int val) {
            while (i < n) {
                tree[i] += val;
                i += (i & -i);
            }
        }

        public long query(int i) {
            long sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= (i & -i);
            }
            return sum;
        }
    }
}
