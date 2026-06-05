class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            map.put(position[i], speed[i]);
        }

        Integer[] pos = Arrays.stream(position).boxed().toArray(Integer[]::new);
        Arrays.sort(pos, Collections.reverseOrder());

        Stack<Double> st = new Stack<>();
        
        for(int i = 0; i < len; i++){
            double time = (double)(target - pos[i]) / map.get(pos[i]);
            if(st.isEmpty() || st.peek() < time){
                st.push(time);
            }
        }

        return st.size();
    }
}
