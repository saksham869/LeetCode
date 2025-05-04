import java.util.*;

public class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int median = arr[(arr.length - 1) / 2];
        
        return Arrays.stream(arr)
                .boxed()
                .sorted((a, b) -> {
                    int diffA = Math.abs(a - median);
                    int diffB = Math.abs(b - median);
                    return diffA == diffB ? b - a : diffB - diffA;
                })
                .limit(k)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
