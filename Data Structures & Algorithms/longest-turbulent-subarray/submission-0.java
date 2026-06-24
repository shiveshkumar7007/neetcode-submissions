class Solution {
    public int maxTurbulenceSize(int[] arr) {

        // Length of turbulent subarray ending at current index
        // where last comparison was ">"
        int up = 1;

        // Length of turbulent subarray ending at current index
        // where last comparison was "<"
        int down = 1;
        int ans = 1;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i-1] < arr[i]) {
                // Current comparison is ">"
                // Extend a sequence that previously ended with "<"
                up = down + 1;
                down = 1;
            }
            else if(arr[i-1] > arr[i]) {
                // Current comparison is "<"
                // Extend a sequence that previously ended with ">"
                down = up + 1;
                up = 1;
            }
            else {
                // Equal elements break turbulence
                up = 1;
                down = 1;
            }
            // Update maximum turbulent length found so far
            ans = Math.max(ans, Math.max(up, down));
        }

        return ans;
    }
}