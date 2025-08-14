class Solution {
    public int romanToInt(String s) {
        // Step 1: Create a map for Roman numeral values
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        // Step 2: Iterate through the string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int currValue = romanMap.get(s.charAt(i));

            // Step 3: Check if we need to subtract or add
            if (currValue < prevValue) {
                result -= currValue;  // Subtract if smaller than the previous value
            } else {
                result += currValue;  // Otherwise, add
            }

            prevValue = currValue;  // Update the previous value
        }

        return result;
    }
}
