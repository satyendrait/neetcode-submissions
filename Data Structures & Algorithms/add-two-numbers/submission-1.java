/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curr = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            ListNode n = null;
            ListNode n2 = null;
            int sum;
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                sum = l1.val + carry;
                l1 = l1.next;
            } else {
                sum = l2.val + carry;
                l2 = l2.next;
            }
            if (sum < 10) {
                n = new ListNode(sum);
                carry = 0;
            } else {
                n = new ListNode(sum % 10);
                carry = 1;
            }
            if (head == null) {
                head = n;
                curr = n;
            } else {
                curr.next = n;
                curr = n;
            }
        }
        if (carry == 1) {
            curr.next = new ListNode(1);
        }
        return head;
    }
}
