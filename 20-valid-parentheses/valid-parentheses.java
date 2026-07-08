class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else { // closing bracket.
                if (st.isEmpty()) {
                    return false;
                }
                char top = st.peek();
                if(sameStyle(top, ch)){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return (st.size() == 0);
    }
    public boolean sameStyle(char top, char ch){
        if(top == '(' && ch == ')'){
            return true;
        }
        if(top == '{' && ch == '}'){
            return true;
        }
        if(top == '[' && ch == ']'){
            return true;
        }
        return false;
    }
}