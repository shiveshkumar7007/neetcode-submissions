class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for(int wt: weights){
            low = Math.max(low, wt);
            high += wt;
        }
        int ans = 0;
 
        while(low <= high){
            int mid = low + (high-low)/2;
            if(canShip(weights, days, mid)){
                ans = mid;
                high = mid-1;
            } else{
                low = mid+1;
            }
        }

        return ans;
    }

    public boolean canShip(int[] weights, int days, int capacity){
        int curr = 0;
        int reqDays = 1;

        for(int wt: weights){
            if(curr + wt > capacity){
                reqDays++;
                curr = wt;
            } else{
                curr += wt;
            }
        }

        return reqDays <= days;
    }
}