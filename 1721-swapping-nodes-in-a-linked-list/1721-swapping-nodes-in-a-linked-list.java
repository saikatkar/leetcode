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
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode temp = head;
        ListNode preTemp = null;
        ListNode kTemp = head;
        ListNode preKTemp = null;
        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        int i = 1;
        temp = head;
        while (i < k ) {
            preTemp = temp;
            temp = temp.next;
            i++;
        }
        i = 1;
        while (i < len-k+1) {
            preKTemp = kTemp;
            kTemp = kTemp.next;
            i++;
        }
        int tVal = temp.val;
        temp.val = kTemp.val;
        kTemp.val = tVal;
        
        return head;
    }
}