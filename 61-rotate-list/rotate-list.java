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
        if ( head == null || head.next == null || k ==0)
        return head;
        // find length
        int length = 1;
        ListNode tail = head;
        while (tail.next != null){
            tail = tail.next;
            length ++;
        }
        // rotation at whcih plance is enough
        k = k % length;
        // no rotation
        if ( k == 0)
        return head;

        //make circular
        tail.next = head;
        
        // to find new tail
        int stepsToNewTail  = length - k;
        
        // find new tail
        ListNode newTail = head;
        for ( int i =1; i < stepsToNewTail; i++){
            newTail = newTail.next;
        }

        // new head
        ListNode newHead = newTail.next;

        newTail.next = null;
        return newHead;
    }
}