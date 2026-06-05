class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int res = 0;
        int l[] = new int[len];
        int r[] = new int[len];
        l[0] = height[0];
        r[len-1] = height[len-1];
        for(int i = 1; i < len; i++){
            l[i] = Math.max(l[i-1], height[i]);
        }
        for(int j = len-2; j>=0; j--){
            r[j] = Math.max(r[j+1], height[j]);
        }
        for(int i = 0; i<len; i++){
            res += Math.min(r[i], l[i]) - height[i];
        }
        return res;
    }
}
