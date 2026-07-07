class Solution {
    public long reverse(long x){
        long rev = 0;
        while(x != 0){
            long digit = x % 10;
            rev = rev * 10 + digit;
            x /= 10;
        }
        return rev;
    }
    public long sumAndMultiply(int n) {
        long sum = 0;
        long x = 0;
        while(n != 0){
            long digit = n%10;
            sum += digit;
            if(digit != 0){
                x = x*10 + digit;
            }
            n /= 10;
        }
        System.out.println(x);
        long rev = reverse(x);

        return rev * sum;

    }
}