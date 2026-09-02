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
    public ListNode oddEvenList(ListNode head) {
        ListNode temp = head;
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode temp1=dummy1;
        ListNode temp2=dummy2;
        int count =1;
        while(temp!=null){
            if(count%2!=0){  //odd positions first since first node is ODD
                temp1.next=temp;
                temp1=temp1.next;
            }
            else{ //count%2==0 even positions first, [1]->[2]->[3] positions
                temp2.next=temp;
                temp2=temp2.next;
            }
            temp=temp.next;
            count++;
        }
        temp1.next=dummy2.next;
        temp2.next=null;
        return dummy1.next;
        
    }
}