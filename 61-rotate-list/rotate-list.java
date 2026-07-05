/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int length(ListNode head){
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }
    public ListNode rotateRight(ListNode head, int k) {
        // base case 1;
        if(head == null || head.next == null){
            return head;
        }

        int size = length(head);
        // base case 2
        k = k % size;
        if(k == 0){
            return head;
        }
        //slow and fast pointer apporach
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 1; i<= k+1;i++){
            fast = fast.next;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        ListNode a = slow.next;
        slow.next = null;
        ListNode temp = a;

        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;

        return a;

    }
}