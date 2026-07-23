class Solution {
    public int shipWithinDays(int[] weights, int d) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > max)
                max = weights[i];
            sum += weights[i];
        }

        int lo = max;
        int hi = sum;
        int ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (days(mid, weights) <= d) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }

    public int days(int capacity, int[] arr) {
        int days = 0;
        int c = capacity;
        for (int ele : arr) {
            if (c >= ele) {
                c -= ele;
            } else {
                days++;
                c = capacity - ele;
            }
        }
        days++;
        return days;
    }

}