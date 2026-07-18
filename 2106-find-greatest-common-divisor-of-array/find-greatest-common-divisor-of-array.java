class Solution {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return gdc(min, max);
    }
    public int gdc(int a, int b) {
        while (b != a) {
            if (b >= a)
                b -= a;
            else
                a -= b;
        }
        return a;
    }
}