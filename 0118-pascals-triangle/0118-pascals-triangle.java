import java.util.*;

public class Solution {

    // Function to generate Pascal's Triangle
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) row.add(1); // First and last element are always 1
                else row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
            }
            triangle.add(row);
        }

        return triangle;
    }

    // Main method to run the program
    public static void main(String[] args) {
        Solution sol = new Solution();
        int numRows = 5; // You can change this to test with other values
        List<List<Integer>> result = sol.generate(numRows);

        // Print Pascal's Triangle
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}
