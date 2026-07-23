class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int lo = 1;
        int hi = max;
        int ans = max;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (hours(mid, piles) <= h) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }

    private long hours(int speed, int[] piles) {
        long totalHours = 0;

        for (int pile : piles) {
            totalHours += (pile + (long) speed - 1) / speed;
        }

        return totalHours;
    }
}