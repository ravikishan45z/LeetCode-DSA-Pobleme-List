class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {-1,-1};    
        ListNode a = head;
        ListNode b = head.next;
        ListNode c = head.next.next;
        if(c == null){
            return ans;
        }
        int index = 1;
        int firstindex = -1;
        int lastindex = -1;
        int minDist = Integer.MAX_VALUE;
        while(c != null){
            if((b.val > a.val && b.val > c.val) || (b.val < a.val && b.val < c.val)){
                if(firstindex == -1){
                    firstindex = index;
                }
                if(lastindex != -1){
                    int dist = index - lastindex;
                    minDist = Math.min(minDist, dist);
                }
                lastindex = index;
            }
            index++;
            a = a.next;
            b = b.next;
            c = c.next;
        }
        int maxDist = lastindex - firstindex;
        if(maxDist == 0){
            maxDist = -1;
        }
        if(minDist == Integer.MAX_VALUE){
            minDist = -1;
        }
        ans[0] = minDist;
        ans[1] = maxDist;
        
        return ans;
    }
}