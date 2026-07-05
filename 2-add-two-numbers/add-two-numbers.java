class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;

        while(t1 != null || t2 != null){
            int x = (t1 != null) ? t1.val : 0;
            int y = (t2 != null) ? t2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            temp.next = new ListNode(sum % 10);
            temp = temp.next;

            if(t1 != null){
                t1 = t1.next;
            }
            if(t2 != null){
                t2 = t2.next;
            }
        }
        if(carry != 0){
            temp.next = new ListNode(carry);
        }
        return dummy.next;
    }
}