class Solution {
    int fibo[] = new int[46];
    public int climbStairs(int n) {
        if(fibo[n] != 0){
            return fibo[n];
        }
        if(n == 0 || n == 1){
            return fibo[n] = 1;
        }
        return fibo[n] = climbStairs(n-1) + climbStairs(n-2);
    }
}
