class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){ //base cases.
            return head;
        }

        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode t1 = dummy1;
        ListNode t2 = dummy2;
        ListNode temp = head;

        while(temp != null){
            if(temp.val < x){
                t1.next = temp;
                t1 = t1.next;
                // temp = temp.next;
            }else{
                t2.next = temp;
                t2 = t2.next;
                // temp = temp.next;
            }
            temp = temp.next;
        }
        // t1.next = null;
        t1.next = dummy2.next;
        t2.next = null;
        
        return dummy1.next;
    }
}