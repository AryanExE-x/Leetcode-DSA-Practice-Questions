/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    private Node deepCopy(Node head1){
        Node temp1=head1;
        Node head2 = new Node(-1);
        Node temp2=head2;
        while(temp1!=null){ //deep copy
            Node t = new Node(temp1.val);
            temp2.next=t;
            temp2=temp2.next;
            temp1=temp1.next;
        }
        return head2.next;
    }
    private void merge(Node head1,Node head2){
        Node dummy = new Node(-1);
        Node temp=dummy;
        Node temp1=head1;
        Node temp2=head2;
        while(temp2!=null){
            temp.next=temp1;
            temp1=temp1.next;
            temp=temp.next;

            temp.next=temp2;
            temp2=temp2.next;
            temp=temp.next;
        }
    }
    private void randomConnections(Node head1, Node head2){
        Node temp1=head1;
        Node temp2=head2;
        while(temp1!=null && temp2!=null){
            if(temp1.random==null) temp2.random=null;
            else temp2.random=temp1.random.next;
            temp1=temp1.next.next;
            if(temp2.next!=null) temp2=temp2.next.next;
        }
    }
    private void split(Node head1){
        Node dummy1= new Node(-1);
        Node temp1=dummy1;
        Node dummy2= new Node(-1);
        Node temp2=dummy2;
        Node temp=head1; //merged list pe traverse kr rha h
        while(temp!=null){
            temp1.next=temp;
            temp=temp.next;
            temp1=temp1.next;

            temp2.next=temp;
            temp=temp.next;
            temp2=temp2.next;
        }
        temp1.next=null;
    }
    public Node copyRandomList(Node head1) {
        //step1- creating deep copy without random pointers
        Node head2 = deepCopy(head1);
        //step2- alternatively connecting lists
        merge(head1,head2);
        //step3- assigning random connections
        randomConnections(head1,head2);
        //step4- split the lists
        split(head1);
        return head2; //deep copy return kro
    }
    
}