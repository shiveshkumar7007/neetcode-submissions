class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens) {
            if(isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(applyOperator(token, a, b));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public int applyOperator(String op, int a, int b) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
        }
        return 0;
    }
}
