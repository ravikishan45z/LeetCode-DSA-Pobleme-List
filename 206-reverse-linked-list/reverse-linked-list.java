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
    public ListNode reverseList(ListNode head) {
        //------------------Brute Force Apporach----------------

        // if(head == null){
        //     return null;
        // }
        // if(head.next == null){
        //     return head;
        // }
        // ListNode temp = head;
        // List<ListNode> arr = new ArrayList<>();
        // while(temp != null){
        //     ListNode t1 = temp;
        //     arr.add(t1);
        //     temp = temp.next;
        // }
        // int n = arr.size();
        // for(int i = n-1; i>= 1; i--){
        //     arr.get(i).next = arr.get(i-1);
        // }
        // arr.get(0).next = null;

        // return arr.get(n-1);

        //---------------------Optimal apporach------------------
        ListNode prev = null;
        ListNode curr = head;
        ListNode ford = null;
        while(curr != null){
            ford = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ford;
        }
        return prev;
    }
}