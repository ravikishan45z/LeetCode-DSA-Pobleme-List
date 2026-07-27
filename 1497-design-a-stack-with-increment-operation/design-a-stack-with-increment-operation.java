class CustomStack {
    int n;
    int[] arr;
    Stack<Integer> st;
    public CustomStack(int maxSize) {
        n = maxSize;
        arr = new int[n];
        st = new Stack<>();
    }
    
    public void push(int x) {
        if(st.size() < n){
            st.push(x);
        }
    }
    
    public int pop() {
        int i = st.size() -1;
        if(i < 0) return -1;
        if(i > 0) arr[i-1] += arr[i];
        int res = st.pop() + arr[i];
        arr[i] = 0;
        return res;
    }
    
    public void increment(int k, int val) {
        int i = Math.min(k, st.size()) - 1;
        if(i >= 0) arr[i] += val;
    } 
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */