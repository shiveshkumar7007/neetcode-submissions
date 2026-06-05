class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token: tokens){
            if(isOperator(token)){
                int b = st.pop();
                int a = st.pop();
                st.push(applyOperator(token, a, b));
            } else{
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();        
    }

    public boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public int applyOperator(String s, int a, int b){
        if(s.equals("+"))    return a+b;
        if(s.equals("-"))    return a-b;
        if(s.equals("*"))    return a*b;
        if(s.equals("/"))    return a/b;
        return 0;
    }
}
