class MinStack {
    private Stack<Long> MinStack1;
    private long min;

    public MinStack() {
        MinStack1=new Stack<>();
        min=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        long val1=(long) val;
        if(MinStack1.isEmpty()){
            MinStack1.push(val1);
            min=val1;
        }
        else{
            if(val1>=min){
                MinStack1.push(val1);
            }
            else{
                MinStack1.push(2*val1-min);
                min=val1;
            }
        }
    }
    
    public void pop() {
        if(MinStack1.isEmpty()){
            return;
        }
        long top=MinStack1.pop();
        if(top<min){
            min=2*min-top;
        }
    }
    
    public int top() {
        if(MinStack1.isEmpty()){
            return -1;
        }
        else{
            long top=MinStack1.peek();
            if(top>=min){
                return (int)top;
            }
            else{
                return (int)min;
            }
        }
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */