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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len ++;
        }
        ListNode [] output = new ListNode[k];
        int partLength = len/k;
        int extra = len % k;
        //System.out.println("p" + partLength);
        //System.out.println("extra" + extra);

        int i = 0;
        int e = 0;
        int p = 0;
        temp = head;
        int part = 0;
        while (i < k) {
            if (i < extra) {
                part = partLength + 1;
            } else {
                part = partLength;
            }
            p = 1;
            while (p < part) {
                if (temp != null) {
                    temp = temp.next;   
                }
                p++;
            }
            if (temp != null) {
                ListNode prev = temp;
                temp = temp.next;
                prev.next = null;
            }
            output[e++] = head;
            head = temp;
            i++;
        }
        return output;
    }
}