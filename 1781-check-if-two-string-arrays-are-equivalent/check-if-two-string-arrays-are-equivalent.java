class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder("");
        StringBuilder s2 = new StringBuilder("");

        for(int i = 0; i < word1.length; i++){
            s1.append(word1[i]);
        }

        for(int i = 0; i < word2.length; i++){
            s2.append(word2[i]);
        }

        if(s1.length() != s2.length()){
            return false;
        }
        int i = 0;
        int j = 0;
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) != s2.charAt(j)){
                return false;
            }
            i++;
            j++;
        }

        return true;
    }
}