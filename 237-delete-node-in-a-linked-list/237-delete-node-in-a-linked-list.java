/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode curr = node;
        ListNode prev = node;
        
        curr = curr.next;
        prev.val = curr.val;
        prev.next = curr.next;
    }
}