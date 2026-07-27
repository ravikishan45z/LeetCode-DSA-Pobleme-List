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
    public int numComponents(ListNode head, int[] nums) {
        ListNode temp = head;

        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }

        int count = 0;
        boolean flag = false;
        while(temp != null){
            if(set.contains(temp.val) && !flag){
                count++;
                flag = true;
            }else if( !set.contains(temp.val) && flag){
                flag = false;
            }
            temp = temp.next;
        }
        return count;
    }
}