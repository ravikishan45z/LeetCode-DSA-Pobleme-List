//-------------- Brute Forece-------- steps----------
// step 1 = convert to arratlist.
// step 2 = merge 2 last node and add them


//class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         if(lists.length == 0){
//             return null;
//         }
//         ArrayList<ListNode> arr = new ArrayList<>();
//         for(ListNode n : lists){
//             arr.add(n);
//         }

//         while(arr.size() > 1){
//             ListNode a = arr.get(arr.size() -1);
//             arr.remove(arr.size() -1);
//             ListNode b = arr.get(arr.size() -1);
//             arr.remove(arr.size() -1);
//             ListNode c = merge(a,b);
//             arr.add(c);
//         }
//         return arr.get(0);
//     }
//     public ListNode merge(ListNode head1, ListNode head2){
//         ListNode i = head1;
//         ListNode j = head2;
//         ListNode dummy = new ListNode(-1);
//         ListNode k = dummy;
//         while(i != null && j != null){
//             if(i.val < j.val){
//                 k.next = i;
//                 i = i.next;
//             }else{
//                 k.next = j;
//                 j = j.next;
//             }
//             k = k.next;
//         }
//         if(i != null){
//             k.next = i;
//             i  = i.next;
//         }else{
//             k.next = j;
//             j = j.next;
//         }
//         return dummy.next;
//     }
// }

// ------------------------Optimal Apporach--------------------
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ArrayList<ListNode> arr = new ArrayList<>();
        for (ListNode n : lists) {
            arr.add(n);
        }
        ArrayList<ListNode> arr2 = new ArrayList<>();
        while (arr.size() + arr2.size() > 1) {
            // Merge from arr -> arr2
            while (arr.size() > 1) {
                ListNode a = arr.remove(arr.size() - 1);
                ListNode b = arr.remove(arr.size() - 1);
                arr2.add(merge(a, b));
            }

            if (arr.size() == 1) {
                arr2.add(arr.remove(0));
            }
            // Merge from arr2 -> arr
            while (arr2.size() > 1) {
                ListNode a = arr2.remove(arr2.size() - 1);
                ListNode b = arr2.remove(arr2.size() - 1);
                arr.add(merge(a, b));
            }
            if (arr2.size() == 1) {
                arr.add(arr2.remove(0));
            }
        }
        return arr.isEmpty() ? arr2.get(0) : arr.get(0);   
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode i = head1;
        ListNode j = head2;
        ListNode dummy = new ListNode(-1);
        ListNode k = dummy;
        while (i != null && j != null) {
            if (i.val < j.val) {
                k.next = i;
                i = i.next;
            } else {
                k.next = j;
                j = j.next;
            }
            k = k.next;
        }
        if (i != null) {
            k.next = i;
        } else {
            k.next = j;
        }
        return dummy.next;
    }
}

















