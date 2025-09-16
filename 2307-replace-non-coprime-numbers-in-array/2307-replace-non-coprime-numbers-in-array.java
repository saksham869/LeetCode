import java.util.*;

public class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : nums) {
            stack.addLast(num);
            while (stack.size() >= 2) {
                int y = stack.removeLast();
                int x = stack.removeLast();
                int g = gcd(x, y);
                if (g == 1) {
                    stack.addLast(x);
                    stack.addLast(y);
                    break;
                }
                stack.addLast(lcm(x, y));
            }
        }
        return new ArrayList<>(stack);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}
