import java.util.*;

public class Solution {
    public int maxEvents(int[][] events) {
        // Step 1: Sort the events by their start day
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        // Step 2: Priority Queue (Min-Heap) based on end day
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int i = 0;  // Pointer to iterate through events
        int n = events.length;
        int day = 0; // Current day
        int attended = 0; // Count of events attended

        // Step 3: Find the maximum possible day
        int lastDay = 0;
        for (int[] event : events) {
            lastDay = Math.max(lastDay, event[1]);
        }

        // Step 4: Process from day 1 to lastDay
        for (day = 1; day <= lastDay; day++) {
            // Add events that start today to the minHeap
            while (i < n && events[i][0] == day) {
                minHeap.offer(events[i][1]);
                i++;
            }

            // Remove events from heap that have already ended
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend the event that ends the earliest
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                attended++;
            }
        }

        return attended;
    }
}
