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
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        curr = head;
        int pre = 0;
        ListNode preN = null;
        while (curr != null && pre < size - n) {
            pre++;
            preN = curr;
            curr = curr.next;
        }

        if(preN == null){
            head = head.next;
        }else{
            preN.next=preN.next.next;
        }
        return head;
    }
}
