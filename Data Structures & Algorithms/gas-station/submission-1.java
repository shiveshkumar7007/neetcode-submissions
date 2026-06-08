class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int n = gas.length;
        int tank = 0;
        int ans = 0;
        for (int i=0; i<n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank = tank + gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                ans = i+1;
            }
        }
        return (totalGas < totalCost) ? -1 : ans;
    }
}
