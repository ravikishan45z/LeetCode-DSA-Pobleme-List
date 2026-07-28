class pair implements Comparable<pair> {
    int num;
    int index;

    pair(int num, int index) {
        this.num = num;
        this.index = index;
    }

    public int compareTo(pair p) {
        return Integer.compare(this.num, p.num);
    }
}

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        PriorityQueue<pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<n; i++){
           pq.add(new pair(score[i], i));
        }
        
        String[] res = new String[n];
        int i = 0;
         while (!pq.isEmpty()) {
            pair top = pq.remove();
            if (i == 0) {
                res[top.index] = "Gold Medal";
            }
            else if (i == 1) {
                res[top.index] = "Silver Medal";
            }
            else if (i == 2) {
                res[top.index] = "Bronze Medal";
            }
            else {
                res[top.index] = String.valueOf(i + 1);
            }
            i++;
        }
        return res;
    }
}