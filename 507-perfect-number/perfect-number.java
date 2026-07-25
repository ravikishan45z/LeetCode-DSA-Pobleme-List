class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num < 2) return false;
        int s = 1;
        int i = 2;
        while( i*i <= num){
            if(num%i == 0){
                s += i;
                if( i*i != num){
                    s+=num/i;
                }
            }
            i++;
        }
        return s == num;
    }
}