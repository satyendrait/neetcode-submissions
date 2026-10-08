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
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        curr = null;
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            ListNode ls = list.get(l);
            ListNode rs = list.get(r);
            if (l == r) {
                rs = null;
            }
            ls.next = rs;
            if (curr == null) {
                curr = ls;
            } else {
                curr.next = ls;
            }
            curr = rs;
            l++;
            r--;
        }
        if (curr != null)
            curr.next = null;
    }
}
