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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
       
        ListNode prev = head;
        ListNode curr = head;
        while (curr != null) {
             if (curr.val == val) {
                prev.next = curr.next;
                curr = curr.next; 
                 if (head.val == val) {
                    head = head.next;
                 } 
            } else {
                 prev = curr;
                 curr = curr.next;
             }
        }
        return head;
    }
}