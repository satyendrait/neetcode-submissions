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
    public ListNode reverseList(ListNode head) {
        ListNode reverseList = null;

        while (head != null) {
            ListNode cn = head;
            head = cn.next;
            cn.next = null;
            if (reverseList == null) {
                reverseList = cn;
            } else {
                cn.next = reverseList;
                reverseList = cn;
            }
        }
        return reverseList;
    }
}
