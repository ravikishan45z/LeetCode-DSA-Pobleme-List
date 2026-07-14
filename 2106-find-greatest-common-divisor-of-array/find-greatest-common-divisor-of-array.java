class Solution {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int gcd = 1;

        for(int i = 0;i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
            if(nums[i] < min){
                min = nums[i];
            }
        }

        for(int i = 1; i<=max; i++){
            if(min  % i ==0 && max % i == 0){
                gcd = i;
            }
        }
        return gcd;
    }
}