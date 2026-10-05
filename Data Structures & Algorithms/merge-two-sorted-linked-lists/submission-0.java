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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode res = null;
        ListNode resCurr = null;
        while (list1 != null || list2 != null) {
            ListNode sn = null;
            if (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    sn = list1;
                    list1 = list1.next;
                } else {
                    sn = list2;
                    list2 = list2.next;
                }
            } else if (list1 != null) {
                sn = list1;
                list1 = list1.next;
            } else if (list2 != null) {
                sn = list2;
                list2 = list2.next;
            }
            if (res == null) {
                res = sn;
                resCurr = sn;
            } else {
                resCurr.next = sn;
                resCurr = sn;
            }
        }
        return res;
    }
}