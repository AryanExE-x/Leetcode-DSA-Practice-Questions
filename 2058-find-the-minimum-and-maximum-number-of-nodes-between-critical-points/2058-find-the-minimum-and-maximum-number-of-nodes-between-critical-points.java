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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {-1,-1};
        int idx=1, firstIndex=-1, lastIndex=-1, minDist=Integer.MAX_VALUE;
        ListNode a = head;
        ListNode b = a.next;
        ListNode c = b.next;
        if(c==null) return ans;  //matlab 2 size ki ll

        while(c!=null){
            //check for critical points
            if((b.val>a.val && b.val>c.val) || (b.val<a.val && b.val<c.val)){
                if(firstIndex==-1) firstIndex=idx; //update krdo first index ko
                if(lastIndex!=-1){ //matlab already koi lastindex aa rakha hai
                    int dist = idx-lastIndex;
                    minDist=Math.min(dist,minDist);
                }
                lastIndex=idx;
            }
            idx++;
            a=a.next;
            b=b.next;
            c=c.next;
        }
        int maxDist=lastIndex-firstIndex;
        if(maxDist==0) maxDist=-1; //ek hi critical node 
        if(minDist==Integer.MAX_VALUE) minDist=-1; //ek hi critical node
        ans[0]=minDist;
        ans[1]=maxDist;   
        return ans;
    }
}