class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int l = 0;
        int r = heights.length - 1;
        for(int i = 0; i < heights.length; i++){
            int area = Math.min(heights[l], heights[r]) * (r-l);
            if(heights[l] <= heights[r]){
                l++;
            } else{
                r--;
            }
            max = max > area ? max:area;
        }
        return max;
    }
}
