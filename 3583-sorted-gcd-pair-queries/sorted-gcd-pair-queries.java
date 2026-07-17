class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        long[] gcdCount = new long[max + 1];

        for (int d = max; d >= 1; d--) {
            long cnt = 0;

            for (int multiple = d; multiple <= max; multiple += d)
                cnt += freq[multiple];

            long pairs = cnt * (cnt - 1) / 2;

            for (int multiple = d * 2; multiple <= max; multiple += d)
                pairs -= gcdCount[multiple];

            gcdCount[d] = pairs;
        }

        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++)
            prefix[i] = prefix[i - 1] + gcdCount[i];

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long k = queries[i] + 1; // 1-based position

            int l = 1, r = max;
            while (l < r) {
                int mid = (l + r) / 2;
                if (prefix[mid] >= k)
                    r = mid;
                else
                    l = mid + 1;
            }
            ans[i] = l;
        }

        return ans;
    }
}