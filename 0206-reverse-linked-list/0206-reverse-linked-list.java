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
    public ListNode reverseList(ListNode head) {
        //ListNode prev = null;
        //ListNode current = head;
        //ListNode forward = null;
        //while(current!=null){
          //  forward=current.next;
            //current.next=prev;
           // prev=current;
           // current=forward;
        //}
        //return prev;
        if(head==null) return head;
        if(head.next==null) return head;
        
        ListNode a = head.next;
        head.next=null;
        ListNode b = reverseList(a);
        a.next = head;
        return b;
    }
}