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
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        ListNode next = head.next;
        
        while (curr != null && next != null) {
            prev.next = next;
            curr.next = next.next;
            next.next = curr;
            if (curr.next == null || curr.next.next == null) {
                break;
            }
            prev = curr;
            curr = curr.next;
            next = curr.next;
        }
        return dummy.next;
    }
}