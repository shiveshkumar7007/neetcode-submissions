class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minval = Integer.MAX_VALUE;
        for(int n: prices){
            profit = Math.max(n-minval, profit);
            minval = Math.min(minval, n);
        }
        return profit;
    }
}
