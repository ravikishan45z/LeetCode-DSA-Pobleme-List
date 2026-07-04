class Solution {
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();

        for(int i = 0; i<str.length; i = i+ 2*k){
            int st = i;
            int end = Math.min(i+k -1, str.length -1);
            while(st < end){
                char temp = str[st];
                str[st++] = str[end];
                str[end--] = temp;
            }
        }
        return new String(str);
    }
}