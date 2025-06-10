import java.util.*;

public class Solution {
    public int maxDifference(String s) {
        // Step 1: Count character frequencies
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        int maxDiff = Integer.MIN_VALUE;

        // Step 2: Try every odd-frequency char against every even-frequency char
        for (Map.Entry<Character, Integer> oddEntry : freqMap.entrySet()) {
            int freqOdd = oddEntry.getValue();
            if (freqOdd % 2 == 0) continue; // skip if not odd

            for (Map.Entry<Character, Integer> evenEntry : freqMap.entrySet()) {
                int freqEven = evenEntry.getValue();
                if (freqEven % 2 != 0) continue; // skip if not even

                maxDiff = Math.max(maxDiff, freqOdd - freqEven);
            }
        }

        return maxDiff;
    }
}
