class Solution {
    public boolean stoneGame(int[] piles) {
        int l = 0;
        int r = piles.length-1;
        int a = 0;
        int b = 0;
        while(l < r){
            if(piles[l] >= piles[r]){
                a += piles[l];
                b+= piles[r];
            }else{
                a += piles[r];
                b+= piles[l];
            }
            l++;
            r--;
        }
        return a>b;
    }
}
// alex will always win just return true