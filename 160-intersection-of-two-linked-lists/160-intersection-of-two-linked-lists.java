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

//since we traverse both the lists time complexity is O(m+n)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {      
     HashSet<ListNode> visit = new HashSet<>();
        while(headA!=null){
            visit.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if(visit.contains(headB)) return headB;
            headB= headB.next;
        } return null;
    }
}