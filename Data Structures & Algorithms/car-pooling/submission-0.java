class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] stops = new int[1001]; // locations are <= 1000

        for (int[] trip : trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            stops[from] += passengers; // pick up
            stops[to] -= passengers;   // drop off
        }

        int current = 0;
        for (int i = 0; i <= 1000; i++) {
            current += stops[i];
            if (current > capacity)
                return false;
        }
        return true;
    }
}