class MinStack {
    Stack<Long> st;
    long min;
    public MinStack() {
        st = new Stack<>();
        min=Long.MAX_VALUE;
    }
    
    public void push(int value) {
        if(st.size()==0) min = (long)value;
        if((long)value>min) st.push((long)value);
        else { //stack mein fake value daalo
            st.push((long)value + ((long)value-min));
            min = (long)value;
        }
    }
    
    public void pop() {
        if(st.peek()>=min) st.pop();
        else{ //locha hai st.peek()<min , minimum roll back karo
            min = min + (min - st.peek());
            st.pop();
        }
    }
    
    public int top() {
        long a = st.peek();
        if(a>=min) return (int)a;
        else{ //locha hai st.peek()<min , minimum roll back karo  
            return (int)min;
        }
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */