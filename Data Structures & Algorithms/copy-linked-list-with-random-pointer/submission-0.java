/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
       // Map original node -> cloned node
        Map<Node, Node> oldToNew = new HashMap<>();
        
        // Step 1: Create all new nodes without pointers
        Node curr = head;
        while (curr != null) {
            oldToNew.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        
        // Step 2: Assign next and random pointers using the map
        curr = head;
        while (curr != null) {
            Node clonedNode = oldToNew.get(curr);
            clonedNode.next = oldToNew.get(curr.next);
            clonedNode.random = oldToNew.get(curr.random);
            curr = curr.next;
        }
        
        return oldToNew.get(head);
    }
}
