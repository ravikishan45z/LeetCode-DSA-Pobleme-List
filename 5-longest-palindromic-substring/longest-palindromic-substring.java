class Solution {
    public boolean isPalidrome(String s){
        int left = 0;
        int right = s.length() -1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n <= 1){
            return s;
        }

        int maxLen = 1;
        String maxStr = s.substring(0,1);
        
        for(int i = 0; i < n; i++) {
            for(int j = i+maxLen; j <= n; j++) {
                if(j - i > maxLen && isPalidrome(s.substring(i,j))) {
                    maxLen = j-i;
                    maxStr = s.substring(i,j);
                }
            }
        }

        return maxStr;
    }
}