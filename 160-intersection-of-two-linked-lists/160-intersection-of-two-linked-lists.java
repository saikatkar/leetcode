/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m = 1;
        int n = 1;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null) {
            tempA = tempA.next;
            m++;
        }
        while (tempB != null) {
            tempB = tempB.next;
            n++;
        }
        int k = 0;
        boolean flag = false;
        ListNode temp = null;
        if (m > n) {
            k = m-n;
            temp = headA;
            flag = true;
        } else {
            k = n-m;
            temp = headB;
        }
        
        while (k > 0) {
            temp = temp.next;
            k--;
        }
        ListNode temp1 = null;
        if (flag) {
            temp1 = headB;
        } else {
            temp1 = headA;
        }
        
        while (temp1 != null && temp != null) {
            if (temp1 == temp) {
                return temp1;
            }
            temp1 = temp1.next;
            temp = temp.next;
            
        }
        
        return null;
        
    }
}