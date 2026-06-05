class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = position.length;
        for(int i = 0; i < len; i++){
            map.put(position[i], speed[i]);
        }
        Arrays.sort(position);
        Stack<Double> st = new Stack<>();
        for(int i = len-1; i >= 0; i--){
            double time = (double)(target-position[i]) / map.get(position[i]);
            if(st.empty() || st.peek() < time){
                st.push(time);
            }
        }
        return st.size();
    }
}
