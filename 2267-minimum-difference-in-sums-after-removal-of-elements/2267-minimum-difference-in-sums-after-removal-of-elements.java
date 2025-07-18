import java.util.*;

class Solution {
    public long minimumDifference(int[] nums) {
        int len = nums.length;
        int n = len / 3;
        long[] prefixSums = new long[len];
        long[] suffixSums = new long[len];
        
        // Step 1: prefix sums (smallest possible sum of n elements)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int i = 0; i < 2 * n; i++) {
            maxHeap.offer(nums[i]);
            sum += nums[i];
            if (maxHeap.size() > n) {
                sum -= maxHeap.poll();
            }
            if (maxHeap.size() == n) {
                prefixSums[i] = sum;
            }
        }

        // Step 2: suffix sums (largest possible sum of n elements)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        sum = 0;
        for (int i = len - 1; i >= n; i--) {
            minHeap.offer(nums[i]);
            sum += nums[i];
            if (minHeap.size() > n) {
                sum -= minHeap.poll();
            }
            if (minHeap.size() == n) {
                suffixSums[i] = sum;
            }
        }

        // Step 3: compute minimum difference
        long ans = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            ans = Math.min(ans, prefixSums[i] - suffixSums[i + 1]);
        }

        return ans;
    }
}
