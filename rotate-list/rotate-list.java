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
    public ListNode rotateRight(ListNode head, int k) {
        int size = 0;
        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            size++;
        }
        if(size == 0) {
            return head;
        }
        k = k % size;
        if(head == null || k == 0) {
            return head;
        }
        ListNode newHead = reverseLinkedList(head);
        curr = newHead;
        for(int i = 1; i < k; i++) {
            curr = curr.next;
        }
        
        ListNode next = curr.next;
        curr.next = null;
        ListNode finalHead = reverseLinkedList(newHead);
        ListNode finalNext = reverseLinkedList(next);
        curr = finalHead;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = finalNext;
        return finalHead;
    }
    
    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}