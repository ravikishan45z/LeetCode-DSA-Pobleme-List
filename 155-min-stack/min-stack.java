class Node {
    int value;
    int min;    // minimum of stack up to this node
    Node next;

    Node(int value, int min) {
        this.value = value;
        this.min = min;
    }
}

class MinStack {
    Node head;

    public MinStack() {
    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val);
        } else {
            Node node = new Node(val, Math.min(val, head.min));
            node.next = head;
            head = node;
        }
    }

    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return head.min;    // O(1) — no more scanning!
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