class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int x : asteroids) {
            boolean destroyed = false;
            while (!st.isEmpty() && st.peek() > 0 && x < 0) {
                if (st.peek() < Math.abs(x)) {
                    st.pop();
                } else if (st.peek() == Math.abs(x)) {
                    destroyed = true;
                    st.pop();
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }
            if (!destroyed) {
                st.push(x);
            }
        }

        int[] res = new int[st.size()];

        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}