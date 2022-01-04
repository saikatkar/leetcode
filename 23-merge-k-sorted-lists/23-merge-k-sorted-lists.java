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
    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> cmp;
        cmp = new Comparator<ListNode>() {  
        @Override
        public int compare(ListNode o1, ListNode o2) {
            // TODO Auto-generated method stub
            return o1.val-o2.val;
        }
        };
        Queue<ListNode> pq = new PriorityQueue<>(cmp);
        ListNode mergedHead = new ListNode();
        ListNode result = mergedHead;
        for (ListNode ln : lists) {
            if(ln != null) {
                pq.add(ln);  
            }
        }
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            mergedHead.next = min;
            mergedHead = mergedHead.next;
            if (min.next != null) {
                min = min.next;
                pq.add(min);
            }
        }
        return result.next;
    }
}