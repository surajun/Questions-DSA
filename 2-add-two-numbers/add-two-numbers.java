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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(-1);  // Dummy node 
        ListNode curr = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            int sum = carry; // start with carry
            
            if (l1 != null) {
                sum += l1.val;   // add t1 digit
                l1 = l1.next;
            }
            
            if (l2 != null) {     // add t2 digit
                sum += l2.val;
                l2 = l2.next;
            }
            
            carry = sum / 10;   //new carry
            ListNode newNode = new ListNode(sum % 10);  // Current digit node
            curr.next = newNode;    // attach to result list
            curr = curr.next;
        }
        
        // If any carry remains, add it as a new node
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        
        return dummy.next;  // Head of result list

    }
}