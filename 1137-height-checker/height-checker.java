class Solution {
    public int heightChecker(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int count = 0;

        int i = 0;
        for(int x: nums){
            arr[i++] = x;
        }
        Arrays.sort(nums);

        for(i = 0; i<n; i++){
            if(arr[i] != nums[i]){
                count++;
            }
        }
        return count;
    }
}