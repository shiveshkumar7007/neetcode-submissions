class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n+1];
        int[] out = new int[n+1];
        for(int edge[]: trust){
            in[edge[1]]++;
            out[edge[0]]++;
        }

        for(int i = 1; i < n+1; i++){
            if(in[i] == n-1 && out[i] == 0){
                return i;
            }
        }
        return -1;
    }
}