class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] differenceArray = new int[n + 1]; // Initialize a difference array with one extra space
      
        // Apply the range update technique using the difference array
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            ++differenceArray[left]; // Increment at the start index for the query
            --differenceArray[right + 1]; // Decrement right+1 index for the query
        }
      
        int currentSum = 0; // To keep track of accumulated sum/references from difference array
        for (int i = 0; i < n; ++i) {
            currentSum += differenceArray[i]; // Update the running sum for current index
          
            // If any number in the original array is greater than the current referenced sum, return false
            if (nums[i] > currentSum) {
                return false;
            }
        }
      
        // All indices meet the condition; return true
        return true;
    }
}