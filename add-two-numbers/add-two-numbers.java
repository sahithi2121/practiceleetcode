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
    if(l1==null) return l2;
    if(l2==null) return l1;
    ListNode result = new ListNode(0);
    ListNode iter = result;
        int carry = 0;
    while(l1!=null || l2!=null){
        if(l1!=null){
            carry = carry + l1.val;
            l1 = l1.next;
        }
        if(l2!= null){
            carry = carry +l2.val;
            l2= l2.next;
        }
        iter.next = new ListNode(carry%10);
        iter = iter.next;
        carry = carry/10;
        if(carry>0) iter.next = new ListNode(carry);
    } return result.next;   
    }
}