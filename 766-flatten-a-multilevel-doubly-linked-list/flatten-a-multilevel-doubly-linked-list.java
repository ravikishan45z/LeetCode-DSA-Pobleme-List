class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node curr = head;
        while (curr != null) {
            if (curr.child == null) {
                curr = curr.next;
            } else {
                Node a = curr.next;
                Node c = flatten(curr.child);
                curr.child = null;
                curr.next = c;
                c.prev = curr;

                Node temp = c;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = a;
                if (a != null) {
                    a.prev = temp;
                }
                curr = a;
            }
        }
        return head;
    }
}