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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (left > 1) {
            prev = curr;
            curr = curr.next;
            left --;
            right --;
        }
        ListNode next = null;
        ListNode first = prev;
        ListNode last = curr;
        while (right > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            right --;
        }
        if (first != null) {
            first.next = prev;
        } else {
            head = prev;
        }
        last.next = curr;
        return head;
    }
}