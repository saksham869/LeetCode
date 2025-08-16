public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);  // Dummy node for result list
        ListNode curr = dummy;  // Pointer to build result list
        int carry = 0;  // Carry variable

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;  // Start with carry

            if (l1 != null) {
                sum += l1.val;  // Add l1's value
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;  // Add l2's value
                l2 = l2.next;
            }

            carry = sum / 10;  // Compute carry
            curr.next = new ListNode(sum % 10);  // Store digit in new node
            curr = curr.next;  // Move pointer
        }

        return dummy.next;  // Return result list (excluding dummy node)
    }
}