import java.util.*;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        // Step 1: Create jobs array and sort by endTime
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1])); // sort by endTime

        // Step 2: Use TreeMap to store (endTime -> maxProfit)
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);  // base case: endTime 0 => profit 0

        for (int[] job : jobs) {
            int s = job[0], e = job[1], p = job[2];

            // Step 3: Get the profit before this job starts
            Integer prev = map.floorKey(s);
            int totalProfit = map.get(prev) + p;

            // Step 4: If this job gives better profit, update map
            if (totalProfit > map.lastEntry().getValue()) {
                map.put(e, totalProfit);
            }
        }

        return map.lastEntry().getValue();
    }
}
