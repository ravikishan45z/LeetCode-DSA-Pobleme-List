class Solution {

    public int size(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public int findGreater(ListNode node, int val) {
        while (node != null) {
            if (node.val > val) {
                return node.val;
            }
            node = node.next;
        }
        return 0;
    }

    public int[] nextLargerNodes(ListNode head) {
        int len = size(head);
        int[] arr = new int[len];

        ListNode curr = head;
        int i = 0;

        while (curr != null) {
            arr[i] = findGreater(curr.next, curr.val);
            curr = curr.next;
            i++;
        }

        return arr;
    }
}