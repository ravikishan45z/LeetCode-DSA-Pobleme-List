class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) max = nums[i];
        }

        int lo = 1;
        int hi = max;
        int ans = -1;

        while(lo <= hi){
            int mid = lo + (hi -lo) / 2;
            if(divs(nums, mid) <= threshold){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return ans;
    }
    public int divs(int[] nums, int val){
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum += (int) Math.ceil((double) nums[i] / val);
        }
        return sum;
    }
}