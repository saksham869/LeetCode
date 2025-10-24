import java.util.HashMap;

class Solution {
    private HashMap<Integer, Integer> memo = new HashMap<>();

    public int fib(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        
        int result = fib(n - 1) + fib(n - 2);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(10)); // Output: 55
    }
}
