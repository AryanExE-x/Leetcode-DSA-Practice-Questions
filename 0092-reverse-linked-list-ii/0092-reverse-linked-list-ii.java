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
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        dummy.next=head;
        for(int i=1;i<=left-1;i++){ //loop chalao left-1 times fir tod dena
            temp=temp.next;
        }
        ListNode tail1=temp;  //mark it
        ListNode head2=tail1.next; //mark it
        tail1.next=null; 
        //WE CANT BREAK IT RN SINCE WE ARE ITERATING TEMP FROM DUMMY. WE CAN BREAK IT IN CASE WE ARE RUNNING THE FOR LOOP FROM HEAD2 TO RIGHT-LEFT;

        temp=head2; //temp ko starting position pe lejao and again loop chalao
        for(int i=1;i<=right-left;i++){ //ab right times chalao fir tod do
            temp=temp.next;
        }
        ListNode tail2=temp;  //mark it
        ListNode head3=tail2.next;  //mark it
        tail2.next=null;

        tail2=reverse(head2); //reverse the sublist

        tail1.next=tail2; //now attach the nodes
        head2.next=head3; //attach the second half with the third half
        return dummy.next; //return the head;
    }
    public ListNode reverse(ListNode head){
        ListNode prev= null;
        ListNode curr=head;
        ListNode forw= null;
        while(curr!=null){
            forw=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forw;
        }
        return prev;
    }
}