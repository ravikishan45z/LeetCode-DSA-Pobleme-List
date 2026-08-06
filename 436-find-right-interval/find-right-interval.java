class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;

        int[] arr = new int[n];
        int[] ans = new int[n];

        for(int i = 0; i< n; i++){
            arr[i] = intervals[i][0];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(arr[i],i);
        }

        Arrays.sort(arr);
        for(int i = 0; i<n; i++){
            int val = BS(arr,intervals[i][1]);
            if(val == -1){
                ans[i] = -1;
            } else {
                ans[i] = map.get(arr[val]);
            }
        }

        return ans;
    }

    public int BS(int[] arr, int target){
        int n = arr.length;
        int lo = 0;
        int hi = n-1;
        int ans = -1;

        while(lo <= hi){
            int mid = lo + (hi -lo) / 2;
            if(arr[mid] > target){
                ans = mid;
                hi = mid - 1;
            } else if(arr[mid] < target){
                lo = mid +1;
            } else{
                return mid;
            }
        }

        return ans;
    }
}