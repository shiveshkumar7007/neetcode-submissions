class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            int currTemp = temperatures[i];

            while (!stack.isEmpty() && temperatures[stack.peek()] <= currTemp){
                stack.pop();
            }
            if (!stack.isEmpty()){
                result[i] = stack.peek() - i;
            } else{
                result[i] = 0;
            }

            stack.push(i);
        }
        return result;
    }
}
