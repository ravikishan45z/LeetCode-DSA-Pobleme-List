class pair implements Comparable<pair> {
	int num;
	int dist;
	pair(int dist, int num) {
		this.dist = dist;
		this.num = num;
	}
	public int compareTo(pair p) {
		if (this.dist == p.dist) {
            return Integer.compare(this.num, p.num);
        }
        return Integer.compare(this.dist, p.dist);
	}
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<pair> pq = new PriorityQueue<>();
        
        for (int num : arr) {
            int dist = Math.abs(num - x);
            pq.add(new pair(dist, num));
        }

        List<Integer> ans = new ArrayList<>();

        while (k > 0) {
            ans.add(pq.remove().num);
            k--;
        }

        Collections.sort(ans);

        return ans;
    }
}
