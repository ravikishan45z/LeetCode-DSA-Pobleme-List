class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int sum = 0;
        int x = n-k;
        if(x < 0){
            x = 1;
        }
        for(int i = x; i <= n+k; i++){
            if(Math.abs(n - i) <= k && (n & i) == 0){
                sum += i;
            }
        }
        return sum;
    }
}