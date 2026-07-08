class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If current capacity can ship within given days
            if (canShip(weights, days, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean canShip(int[] weights, int days, int capacity) {

        int requiredDays = 1;
        int currWeight = 0;

        for (int weight : weights) {
            // Start a new day if current package exceeds capacity
            if (currWeight + weight > capacity) {
                requiredDays++;
                currWeight = weight;
            } else {
                currWeight += weight;
            }
        }
        return requiredDays <= days;
    }
}