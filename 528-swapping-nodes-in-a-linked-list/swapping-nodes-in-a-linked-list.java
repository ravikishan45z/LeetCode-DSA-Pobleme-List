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
    public ListNode swapNodes(ListNode head, int k) {
        // ListNode temp = head;
        // int n = 0;
        // while(temp != null){
        //     temp = temp.next;
        //     n++;
        // }

        // temp = head;
        // ListNode temp2 = head;
        // for(int i = 1; i <= (n-k); i++){
        //     temp2 = temp2.next;
        // }
        // for(int i = 1; i < k; i++){
        //     temp = temp.next;
        // }
        // int data = temp.val;
        // temp.val = temp2.val;
        // temp2.val = data;

        // return head;

        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }

        ListNode start = head;
        for(int i = 1; i<k; i++){
            start = start.next;
        }

        ListNode kthfromstart = start;
        ListNode second = head;

        while(start.next != null){
            start = start.next;
            second = second.next;
        }
        int temp = kthfromstart.val;
        kthfromstart.val =  second.val;
        second.val = temp;

        return head;
    }
}
















