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

/*LOGIC-
1>we keep two pointer slow and fast(both move one at a time)both initially at start of list(at the dummy node)
2>we move the fast to n+1 places away from the slow pointer
3>we then traverse the list we check if fast is equal to null or not,if it is null we know that the slow pointer has reached just one node before the node we need to delete!
4>then we slow.next=slow.next.next! */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
 
   ListNode dummy = new ListNode(0);
        ListNode fast = dummy, slow = dummy;
        dummy.next = head;
        for(int i = 0;i<n+1;i++){
            fast = fast.next;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        } slow.next = slow.next.next;
        return dummy.next;
}
}