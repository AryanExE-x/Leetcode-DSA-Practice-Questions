class MyLinkedList {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    Node head;
    int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }
    
    public int get(int index) {

        if(index < 0 || index >= size)
            return -1;

        Node temp = head;

        for(int i = 0; i < index; i++){
            temp = temp.next;
        }

        return temp.val;
    }
    
    public void addAtHead(int val) {

        Node temp = new Node(val);

        temp.next = head;
        head = temp;

        size++;
    }
    
    public void addAtTail(int val) {

        Node temp = new Node(val);

        if(head == null){
            head = temp;
            size++;
            return;
        }

        Node curr = head;

        while(curr.next != null){
            curr = curr.next;
        }

        curr.next = temp;

        size++;
    }
    
    public void addAtIndex(int index, int val) {

        if(index < 0 || index > size)
            return;

        if(index == 0){
            addAtHead(val);
            return;
        }

        if(index == size){
            addAtTail(val);
            return;
        }

        Node newNode = new Node(val);

        Node temp = head;

        // Reach node before index
        for(int i = 1; i <= index-1; i++){
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        size++;
    }
    
    public void deleteAtIndex(int index) {

        if(index < 0 || index >= size)
            return;

        // Delete head
        if(index == 0){
            head = head.next;
            size--;
            return;
        }

        Node temp = head;

        // Reach node before index
        for(int i = 1; i < index; i++){
            temp = temp.next;
        }

        temp.next = temp.next.next;

        size--;
    }
}