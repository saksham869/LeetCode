import java.util.*;

class Spreadsheet {

    private final Map<String, Integer> spreadsheet;

    public Spreadsheet(int rows) {
        spreadsheet = new HashMap<>();
    }

    public void setCell(String cell, int value) {
        spreadsheet.put(cell, value);
    }

    public void resetCell(String cell) {
        spreadsheet.put(cell, 0);
    }

    public int getValue(String formula) {
        // Formula always in form "=X+Y"
        int plusIdx = formula.indexOf('+');
        String first = formula.substring(1, plusIdx);
        String second = formula.substring(plusIdx + 1);
        return getToken(first) + getToken(second);
    }

    private int getToken(String token) {
        
        if (Character.isDigit(token.charAt(0))) {
            return Integer.parseInt(token);
        }
        
        return spreadsheet.getOrDefault(token, 0);
    }
}
