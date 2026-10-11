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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> nodes = new Stack();
        ListNode curr = head;
        while (curr != null) {
            nodes.push(curr);
            curr = curr.next;
        }
        int size = nodes.size();
        while (!nodes.isEmpty() && nodes.size() > (size - n)) {
            nodes.pop();
        }
        if (!nodes.isEmpty()) {
            ListNode pre = nodes.pop();
            ListNode rem = pre.next;
            if (rem != null) {
                pre.next = rem.next;
            }
        } else {
            head = head.next;
        }
        return head;
    }
}
