class Solution {
    private int[] segTree;
    private int n;

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        n = baskets.length;
        segTree = new int[4 * n];
        build(baskets, 0, n - 1, 1);

        int unplaced = 0;
        for (int fruit : fruits) {
            if (findAndUse(fruit, 0, n - 1, 1) == -1) {
                unplaced++;
            }
        }
        return unplaced;
    }

    private void build(int[] baskets, int low, int high, int idx) {
        if (low == high) {
            segTree[idx] = baskets[low];
            return;
        }
        int mid = low + (high - low) / 2;
        build(baskets, low, mid, idx * 2);
        build(baskets, mid + 1, high, idx * 2 + 1);
        segTree[idx] = Math.max(segTree[idx * 2], segTree[idx * 2 + 1]);
    }

    private int findAndUse(int fruit, int low, int high, int idx) {
        if (segTree[idx] < fruit) return -1;
        if (low == high) {
            segTree[idx] = -1;
            return 1;
        }
        int mid = low + (high - low) / 2;
        int res;
        if (segTree[idx * 2] >= fruit) {
            res = findAndUse(fruit, low, mid, idx * 2);
        } else {
            res = findAndUse(fruit, mid + 1, high, idx * 2 + 1);
        }
        segTree[idx] = Math.max(segTree[idx * 2], segTree[idx * 2 + 1]);
        return res;
    }
}
