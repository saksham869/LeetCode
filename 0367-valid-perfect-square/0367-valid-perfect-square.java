class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        int left = 2;
        int right = num / 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;

            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;  // If loop ends, num is not a perfect square
    }
}
