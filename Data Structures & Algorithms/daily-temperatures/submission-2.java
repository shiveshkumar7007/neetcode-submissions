class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
     int n = temperatures.length;
     Stack<Integer> st = new Stack<>();
     int res[] = new int[n];
     for(int i = n-1; i >= 0; i--){
        int curr = temperatures[i];
        while(!st.isEmpty() && temperatures[st.peek()] <= curr){
            st.pop();
        }
        if(!st.isEmpty()){
            res[i] = st.peek() - i;
        } else{
            res[i] = 0;
        }
        st.push(i);
     }
     return res;
    }
}
