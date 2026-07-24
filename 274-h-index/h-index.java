class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int lo = 0;
        int hi = citations.length - 1;
        int n = citations.length;
        int ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (citations[mid] >= n - mid) {
                ans = n - mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}