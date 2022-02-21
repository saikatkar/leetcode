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
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        ListNode rev = reverse(newHead);
        //System.out.println(rev.val);
        ListNode rev1 = rev;
        ListNode temp = head;
        while (rev1 != null) {
            rev = rev1;
            rev1 = rev1.next;
            //System.out.println(rev.val);
            rev.next = temp.next;
            temp.next = rev;
            temp = temp.next.next;
        }
    }
    
    private ListNode reverse (ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
        
    }
}