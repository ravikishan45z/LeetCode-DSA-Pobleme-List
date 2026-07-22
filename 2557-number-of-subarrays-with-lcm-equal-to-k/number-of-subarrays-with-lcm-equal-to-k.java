class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int l = 1;

            for (int j = i; j < n; j++) {
                l = lcm(l, nums[j]);

                if (l == k) {
                    count++;
                }

                // Optimization: LCM can only increase
                if (l > k || k % l != 0) {
                    break;
                }
            }
        }

        return count;
    }

    private int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}