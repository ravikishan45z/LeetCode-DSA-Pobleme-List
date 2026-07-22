class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 1;

        for(int i = 0; i<n; i++){
            int prod = 1;
            int lcm = 1;
            int gcd = 0;

            for(int j = i; j<n; j++){
                prod *= nums[j];
                gcd = (gcd == 0) ? nums[j] : GCD(gcd, nums[j]);
                lcm = LCM(lcm, nums[j]);

                if(prod == lcm * gcd){
                    ans = Math.max(ans, j-i+1);
                } 
            }
        }
        return ans;
    }
    private int GCD(int a, int b){
        if(a == 0) return b;
        return GCD(b%a, a);
    }
    private int LCM(int a, int b){
        return a * b / GCD(a, b);
    }
}