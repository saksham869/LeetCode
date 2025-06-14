class Solution {
    public boolean isSameAfterReversals(int num) {
        // Step 1: Special case for 0
        if (num == 0) {
            return true;
        }

        // Step 2: If number ends with 0, double reversal will not preserve the number
        if (num % 10 == 0) {
            return false;
        }

        // Step 3: Otherwise, it will be the same after two reversals
        return true;
    }
}
