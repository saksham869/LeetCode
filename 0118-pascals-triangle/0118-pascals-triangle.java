import java.util.*;

public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) row.add(1);
                else row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
            }
            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> result = sol.generate(5);
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}
