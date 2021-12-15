/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
      ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow =slow.next;
            if(fast ==slow)   break;
            
        }

 if (fast == null || fast.next == null)
    // case there is no cycle
    return null;
  
  // let the slow pointer go from the head 
  // and meet the fast pointer
  // the meeting point is our answer
  slow = head;
  
  while (slow != fast) {
    slow = slow.next;
    fast = fast.next;
  }
  
  return slow;
}}