class Solution {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        
        // Step 1: Convert integers to strings
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        // Step 2: Sort strings using custom comparator
        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));

        // Step 3: Edge case - if largest number is "0"
        if (str[0].equals("0")) {
            return "0";
        }

        // Step 4: Build the result string
        StringBuilder result = new StringBuilder();
        for (String s : str) {
            result.append(s);
        }

        return result.toString();
    }
}
