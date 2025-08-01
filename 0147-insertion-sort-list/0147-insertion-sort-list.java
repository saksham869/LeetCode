class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);  // Dummy node to act as head of sorted list
        ListNode curr = head;

        while (curr != null) {
            ListNode prev = dummy;
            // Find the right place to insert curr
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            ListNode nextTemp = curr.next;     // Save the next node
            curr.next = prev.next;             // Insert between prev and prev.next
            prev.next = curr;                  // Link prev to curr
            curr = nextTemp;                   // Move to the next node in original list
        }

        return dummy.next;
    }
}
