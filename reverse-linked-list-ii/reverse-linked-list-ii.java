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
        if (left == right) return head;
        int k = 1;
        
        ListNode dummy = new ListNode(-1000);
        dummy.next = head;
        
        ListNode leftNode = head;
        ListNode leftPrev = dummy;
        
        while (k != left) {
            leftPrev = leftNode;
            leftNode = leftNode.next;
            k++;
        }
        
        // System.out.println(leftNode.val);
        ListNode prev = leftNode;
        ListNode current = leftNode.next;
        ListNode next = null;
        right -= k;
        while (right-- > 0) {
            // System.out.println(right);
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        leftPrev.next = prev;
        leftNode.next = current;
        
        return dummy.next;
    }
}