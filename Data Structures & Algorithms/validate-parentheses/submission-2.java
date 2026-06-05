class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int len = s.length();
        if(len == 1){
            return false;
        }
        for(int i = 0; i < len; i++){
            char ch = s.charAt(i);
            if(ch == '{' || ch == '[' || ch== '('){
                st.push(ch);
                continue;
            }
            if(st.isEmpty()){
                return false;
            }
            if(ch == '}'){
                if(st.pop() != '{'){
                    return false;
                }
            }
            if(ch == ']'){
                if(st.pop() != '['){
                    return false;
                }
            }
            if(ch == ')'){
                if(st.pop() != '('){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
