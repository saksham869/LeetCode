class Solution {
    public int maxDiff(int num) {
        String s = Integer.toString(num);

        // Step 1: Maximize the number
        StringBuilder maxStr = new StringBuilder(s);
        char maxDigitToReplace = ' ';
        for (char c : s.toCharArray()) {
            if (c != '9') {
                maxDigitToReplace = c;
                break;
            }
        }
        if (maxDigitToReplace != ' ') {
            for (int i = 0; i < maxStr.length(); i++) {
                if (maxStr.charAt(i) == maxDigitToReplace) {
                    maxStr.setCharAt(i, '9');
                }
            }
        }

        // Step 2: Minimize the number
        StringBuilder minStr = new StringBuilder(s);
        char minDigitToReplace = ' ';

        if (s.charAt(0) != '1') {
            minDigitToReplace = s.charAt(0);
            for (int i = 0; i < minStr.length(); i++) {
                if (minStr.charAt(i) == minDigitToReplace) {
                    minStr.setCharAt(i, '1');
                }
            }
        } else {
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != '0' && s.charAt(i) != '1') {
                    minDigitToReplace = s.charAt(i);
                    break;
                }
            }
            if (minDigitToReplace != ' ') {
                for (int i = 1; i < minStr.length(); i++) {
                    if (minStr.charAt(i) == minDigitToReplace) {
                        minStr.setCharAt(i, '0');
                    }
                }
            }
        }

        int maxNum = Integer.parseInt(maxStr.toString());
        int minNum = Integer.parseInt(minStr.toString());

        return maxNum - minNum;
    }
}
