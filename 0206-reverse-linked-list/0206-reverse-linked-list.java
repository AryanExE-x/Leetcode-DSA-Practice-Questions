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
        ListNode temp= head;
        ArrayList<ListNode> arr = new ArrayList<>();
        if(head==null) return null; //for indexoutofboundexception error
        while(temp!=null){
            arr.add(temp);  //adding all the "NODES" not the VALUES
            temp=temp.next;
        }
        int n = arr.size();
        for(int i=n-1;i>=1;i--){
            ListNode temp1 = arr.get(i);
            ListNode temp2 = arr.get(i-1);
            temp1.next=temp2;
        }
        arr.get(0).next=null;
        return arr.get(n-1);
    }
}