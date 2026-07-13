class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        int currMax = 0 , currMin = 0;
        int maxSum = nums[0] , minSum = nums[0];

        for(int i=0; i<n; i++){
            //maximum subarray sum
            currMax = Math.max(nums[i],nums[i]+currMax);
            maxSum = Math.max(currMax,maxSum);

            //minimum subarray sum
            currMin = Math.min(nums[i],nums[i]+currMin);
            minSum = Math.min(minSum,currMin);

            totalSum += nums[i];
        }

        int normalSum = maxSum;
        if(minSum == totalSum){
            return normalSum;
        }
        
        int circularSum = totalSum - minSum;

        return Math.max(normalSum,circularSum);
    }
}