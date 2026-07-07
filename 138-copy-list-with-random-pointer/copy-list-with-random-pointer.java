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
    public Node deepCopy(Node head1){
        Node temp1 = head1;
        Node head2 = new Node(-1);
        Node temp2 = head2;
        while(temp1 != null){
            Node t = new Node(temp1.val);
            temp2.next = t;
            temp2 = temp2.next;
            temp1 = temp1.next;
        }
        return head2.next;
    }

    public void merge(Node head1, Node head2){
        Node dummy = new Node(-1);
        Node temp = dummy;
        Node t1 = head1;
        Node t2 = head2;

        while(t2 != null){
            temp.next = t1;
            t1 = t1.next;
            temp = temp.next;

            temp.next = t2;
            t2 = t2.next;
            temp = temp.next;
        }
    }

    public void randomConnection(Node head1, Node head2){
        Node t1 = head1;
        Node t2 = head2;

        while(t1 != null && t2 != null){
            if(t1.random == null){
                t2.random = null;
            }else{
                t2.random = t1.random.next;
            }

            t1 = t1.next.next;
            if(t2.next != null){
                t2 = t2.next.next;
            }
        }
    }
    public void split(Node head1){
        Node dummy1 = new Node(-1);
        Node t1 = dummy1;
        Node dummy2 = new Node(-1);
        Node t2 = dummy2;

        Node temp = head1;
        while(temp != null){
            t1.next = temp;
            temp = temp.next;
            t1 = t1.next;

            t2.next = temp;
            temp = temp.next;
            t2 = t2.next;
        }
        t1.next = null;
    }
    public Node copyRandomList(Node head) {
        // Step 1 : creating deep copy without Random;
        Node head2 = deepCopy(head);

        // Step 2: Creating alternative connection;
        merge(head, head2);

        // Step 3: Assigning random pointers;
        randomConnection(head, head2);

        // Step 4 : Spiliting  the list.
        split(head);   

        return head2; 
    }
}