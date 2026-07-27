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
    public ListNode mergeNodes(ListNode head) {
        int sum = 0;
        ListNode dummy  = new ListNode(-1);
        ListNode temp = dummy;
        ListNode p1 = head;
        ListNode p2 = head;

        while(p2.next != null){
            sum = sum + p2.val;
            p2 = p2.next;
            if(p2.val == 0){
                p1 = p2;
                temp.next = new ListNode(sum);
                sum = 0;
                temp = temp.next;
            }
        }
        return dummy.next;
    }
}