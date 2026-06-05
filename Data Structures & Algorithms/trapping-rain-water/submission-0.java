class Solution {
    public int trap(int[] height) {
        int len = height.length;
        // int l = 0;
        // int r = len-1;
        int res = 0;
        int l[] = new int[len];
        int r[] = new int[len];
        l[0] = height[0];
        r[len-1] = height[len-1];
        for(int i = 1; i < len; i++){
            if(l[i-1] < height[i]){
                l[i] = height[i];
            } else{
                l[i] = l[i-1];
            }
        }
        for(int j = len-2; j>=0; j--){
            if(height[j] > r[j+1]){
                r[j] = height[j];
            } else{
                r[j] = r[j+1];
            }
        }
        for(int i = 0; i<len; i++){
            res += Math.min(r[i], l[i]) - height[i];
        }
        return res;
    }
}
