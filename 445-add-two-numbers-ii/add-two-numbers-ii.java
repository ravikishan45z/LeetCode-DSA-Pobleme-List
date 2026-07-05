class Solution {
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        ListNode t1 = reverse(l1);
        ListNode t2 = reverse(l2);
        int carry = 0;

        while(t1 != null || t2 != null){
            //for assigning values to x and y.
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

        return reverse(dummy.next);
    }
}