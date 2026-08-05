class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'a'){
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            if (s.charAt(i) != 'a') {
                return false;
            }
        }
        return true;
    }
}