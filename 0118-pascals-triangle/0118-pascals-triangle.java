import java.util.*;

public class Solution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (numRows <= 0) return result;
        
        // First row initialization
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);
        
        // Generate remaining rows
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = result.get(i - 1);
            List<Integer> row = new ArrayList<>();
            
            // Start row with 1
            row.add(1);
            
            // Calculate middle elements
            for (int j = 0; j < prevRow.size() - 1; j++) {
                row.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            
            // End row with 1
            row.add(1);
            result.add(row);
        }
        
        return result;
    }

    public static void main(String[] args) {
        int numRows = 5; // Change this value to test
        List<List<Integer>> pascalTriangle = generate(numRows);
        
        // Print Pascal's Triangle
        for (List<Integer> row : pascalTriangle) {
            System.out.println(row);
        }
    }
}
