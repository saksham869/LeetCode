import java.util.*;

public class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> resultSet = new HashSet<>();
        int[] count = new int[10];
        
        // Count the frequency of each digit
        for (int digit : digits) {
            count[digit]++;
        }
        
        // Generate all possible 3-digit numbers
        for (int i = 1; i <= 9; i++) { // Hundreds place (1-9)
            if (count[i] > 0) {
                for (int j = 0; j <= 9; j++) { // Tens place (0-9)
                    if (count[j] > (i == j ? 1 : 0)) {
                        for (int k = 0; k <= 8; k += 2) { // Units place (even digits)
                            if (count[k] > (i == k ? 1 : 0) && (j == k ? count[k] > (i == k ? 2 : 1) : true)) {
                                resultSet.add(i * 100 + j * 10 + k);
                            }
                        }
                    }
                }
            }
        }
        
        // Convert the result set to an array and return it
        List<Integer> resultList = new ArrayList<>(resultSet);
        Collections.sort(resultList);
        int[] ret = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            ret[i] = resultList.get(i);
        }
        return ret;
    }
}
