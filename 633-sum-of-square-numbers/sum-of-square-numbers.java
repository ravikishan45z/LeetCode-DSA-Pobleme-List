class Solution {
    public boolean judgeSquareSum(int c) {
        long i = 0;
        long j = (long)Math.sqrt(c);
        while(i<=j){
            if((i*i) + (j*j) >(long)c){
                j--;
            }else if((i*i)+(j*j) <(long)c){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}