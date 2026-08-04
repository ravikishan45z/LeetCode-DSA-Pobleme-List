class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : stones){
            pq.add(ele);
        }
        while(pq.size() > 1){
            pq.add(pq.remove() - pq.remove());
        }
        return pq.peek();
    }
}