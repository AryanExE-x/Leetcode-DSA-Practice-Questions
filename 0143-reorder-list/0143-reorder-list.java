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
    public void reorderList(ListNode head) { // 1->2->3->4->5->null
        if(head==null || head.next==null) return;
        ListNode slow = head;
        ListNode fast = head;
        //find middle point
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode curr = slow.next;
        slow.next=null; //break the linkedlist into two parts
        //1->2->3->null    4->5->null

        //now reverse the 2nd half of the list 5->4->null
        ListNode prev = null;
        ListNode forward=null;
        while(curr!=null){
            forward=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forward;
        }

        //merge two halves
        ListNode first=head;
        ListNode second=prev;
        while(second!=null){ //either second half will be <= first half 
                //less for odd case, equal for even half case
            ListNode temp1=first.next;
            ListNode temp2=second.next;
            first.next=second;
            second.next=temp1;
            first=temp1;
            second=temp2;
        }

    }
}