class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        
        int n = words.length;
        Boolean ans = false;

        for(int i = 0; i<n; i++){
            String s = words[i];
            ans = check(s,x);
            if(ans == true){
                result.add(i);
            }
        }
        return result;
    }
    public Boolean check(String s, char x){
        int n = s.length();

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == x){
                return true;
            }
        }
        return false;
    }
}