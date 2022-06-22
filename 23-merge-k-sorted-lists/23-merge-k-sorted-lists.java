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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for (ListNode list: lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        
        ListNode head = new ListNode();
        ListNode current = head;
        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            // System.out.println(smallest.val);
            current.next = smallest;
            if (smallest.next != null) {
                pq.add(smallest.next);
            }
            current = current.next;
        }
        
        return head.next;
    }
}