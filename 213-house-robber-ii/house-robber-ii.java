class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return nums[0];
        }
        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] first = new int[n-1];
        for(int i = 0; i<n-1; i++){
            first[i] = nums[i];
        }

        int[] second = new int[n-1];
        int j = 0;
        for(int i = 1; i < n; i++){
            second[j++] = nums[i];
        }
        int ans = Math.max(robbary(first), robbary(second));
        return ans;
    }

    public int robbary(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for(int i = 2; i<n; i++){
            dp[i] = Math.max(arr[i]+dp[i-2], dp[i-1]); 
        }

        return dp[n-1];
    }
}