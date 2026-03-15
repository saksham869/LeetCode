public class Solution {
    public boolean hasCycle(ListNode head) {

        // edge case: list empty or only 1 node → no cycle
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        // fast must not reach the end
        while (fast != null && fast.next != null) {
            slow = slow.next;          // move 1 step
            fast = fast.next.next;     // move 2 steps

            if (slow == fast) {        // cycle found
                return true;
            }
        }

        return false;  // no cycle
    }
}
