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
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        ListNode temp = head;
        int count = 0;
        boolean flag = false;
        while (temp != null) {
            if (set.contains(temp.val)) {
                if (!flag) {
                    count++;
                }
                flag = true;
            } else {
                flag = false;
            }
            temp = temp.next;
        }
        return count;
    }
}