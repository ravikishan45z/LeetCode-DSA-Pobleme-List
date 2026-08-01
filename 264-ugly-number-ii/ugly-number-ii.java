class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> ugly = new ArrayList<>();

        int[] dp = new int[n];
        dp[0] = 1;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        for (int i = 1; i < n; i++) {

            int by2 = dp[p2] * 2;
            int by3 = dp[p3] * 3;
            int by5 = dp[p5] * 5;

            int next = Math.min(by2, Math.min(by3, by5));

            dp[i] = next;

            if (next == by2) p2++;
            if (next == by3) p3++;
            if (next == by5) p5++;
        }

        for (int num : dp) {
            ugly.add(num);
        }

        return ugly.get(n-1);
    }
}