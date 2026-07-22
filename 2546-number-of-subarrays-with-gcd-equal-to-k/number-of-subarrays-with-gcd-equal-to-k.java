class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i<n; i++){
            int g = nums[i];
            for(int j = i; j<n; j++){
                g = gcd(g, nums[j]);
                if(g == k) count++;
            }
        }
        return count;
    }
    private int gcd(int a, int b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
}