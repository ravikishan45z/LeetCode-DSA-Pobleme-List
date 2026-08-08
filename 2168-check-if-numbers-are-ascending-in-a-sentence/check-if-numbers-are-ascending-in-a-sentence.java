class Solution {
    public boolean areNumbersAscending(String s) {
        ArrayList<Integer> list = new ArrayList<>();

        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }

                list.add(num);
            } else {
                i++;
            }
        }

        int n = list.size();
        for(i = 1; i < n; i++){
            if(list.get(i) <= list.get(i-1)){
                return false;
            }
        }
        
        return true;
    }
}