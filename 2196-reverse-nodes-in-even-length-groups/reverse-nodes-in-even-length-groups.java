class Solution {

    public ListNode reverse(ListNode curr, ListNode stop) {
        ListNode prev = null;
        while (curr != stop) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseEvenLengthGroups(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;
        ListNode curr = head;

        int groupSize = 1;

        while (curr != null) {

            ListNode groupStart = curr;

            int count = 0;
            while (count < groupSize && curr != null) {
                curr = curr.next;
                count++;
            }

            ListNode nextGroupStart = curr;

            if (count % 2 == 0) {

                ListNode newHead = reverse(groupStart, nextGroupStart);

                prevGroupEnd.next = newHead;
                groupStart.next = nextGroupStart;

                prevGroupEnd = groupStart;

            } else {

                prevGroupEnd = groupStart;
                for (int i = 1; i < count; i++) {
                    prevGroupEnd = prevGroupEnd.next;
                }
            }

            groupSize++;
        }

        return dummy.next;
    }
}