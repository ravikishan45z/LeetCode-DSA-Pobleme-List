class Solution {
    public int missingNumber(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        
        for(int ele : arr){
            if(ele > max){
                max = ele;
            }
            set.add(ele);
        }
        
        for(int i = 0; i <= max; i++){
            if(!set.contains(i)) {
                return i;
            }
        } 
        
        return max+1;
    }
}