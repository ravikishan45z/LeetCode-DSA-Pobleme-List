class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for(int i = num1; i<= num2; i++){
            ans += wave(i);
        }
        return ans;
    }
    public int wave(int num){
        String s = Integer.toString(num);
        
        int count = 0;
        for(int i = 1; i<s.length()-1; i++){
            char ch = s.charAt(i);
            if((ch > s.charAt(i - 1)) && (ch > s.charAt(i+1)) ||
            (ch < s.charAt(i - 1)) && (ch < s.charAt(i+1))){
                count++;
            }
        }
        return count;
    }

}