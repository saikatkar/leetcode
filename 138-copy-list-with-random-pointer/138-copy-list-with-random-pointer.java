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
        if (head == null) {
            return null;
        }
        Node curr = head;
        //Node temp = null;
       while(curr!=null)
        {
            Node temp=new Node(curr.val);
            temp.next=curr.next;
            curr.next=temp;
            curr=curr.next.next;
        }
//         curr = head;
//         while (curr != null) {
            
//             System.out.println(curr.val);
//             curr = curr.next;
//         }
        //point the random pointers correctly
        curr = head;
        while (curr != null) {
            //System.out.println(curr.val);
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            if (curr.next != null) {
                curr = curr.next.next;
            }
        }
        Node temp = head.next;
        curr = head.next;
        Node curr1 = head;
        while (curr != null && curr1 != null) {
            if (curr1.next != null) {
                curr1.next = curr1.next.next;
            }
            curr1 = curr1.next;
            if (curr.next != null) {
                curr.next = curr.next.next;    
            }
            //System.out.println(curr.val);
            
            curr = curr.next;
        }
        return temp;
    }
}