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
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode forw = null;
        while(curr != null){
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        // ------------------Brute Force-------------------
        // ListNode newnode = reverse(head);
        // ListNode temp = head;
        // int sum = 0;
        // int maxsum = 0;
        // while(temp != null && newnode != null){
        //     sum += (temp.val + newnode.val);
        //     temp = temp.next;
        //     newnode = newnode.next;
        //     maxsum = Math.max(sum, maxsum);
        // }
        // return maxsum;

        //------------------ Optimal ------------------
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = reverse(slow);
        ListNode first = head;
        int maxSum = 0;
        while(second.next != null){
            maxSum = Math.max(maxSum, first.val + second.val);
            first= first.next;
            second = second.next;
        }
        return maxSum;
    }
}