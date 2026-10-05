class MyQueue {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> helper = new Stack<>();
    
    public void push(int x) {  //O(n) with AS- O(1)
        //push at bottom of st
        while(st.size()>0){
            helper.push(st.pop());
        }
        st.push(x);
        while(helper.size()>0){
            st.push(helper.pop());
        }
    }
    
    public int pop() {  //O(1) 
        //st ka top
        return st.pop();
    }
    
    public int peek() { //O(1) 
        //st ka top
        return st.peek();
    }
    
    public boolean empty() {
        return (st.size()==0);
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */