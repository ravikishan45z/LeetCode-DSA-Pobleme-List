class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // brute Force Apporach
        // int n = nums.length;
        // int ans = Integer.MAX_VALUE;
        // for(int i = 0; i<n; i++){
        //     int sum = 0;
        //     for(int j = i; j<n; j++){
        //         sum += nums[j];
        //         if(sum >= target){
        //             int len = j - i + 1;
        //             System.out.println(len);
        //             ans = Math.min(ans,len);
        //             break;
        //         }
        //     }
        // }
        // if(ans == Integer.MAX_VALUE){
        //     return 0;
        // }
        // return ans;


        // Optimal Apporach.
        int n = nums.length;
        int minlength = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for(int right = 0; right < n; right++){
            sum += nums[right];
            while(sum >= target){
                minlength = Math.min(minlength,right - left +1);
                sum -= nums[left];
                left++;
            }
        }
        if(minlength == Integer.MAX_VALUE){
            return 0;
        }
        return minlength;
    }
}