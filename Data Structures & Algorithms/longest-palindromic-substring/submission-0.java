class Solution {
    int max = 0;
    int l = 0;
    int r = 0;
    public String longestPalindrome(String s) {
        for(int i = 0; i < s.length(); i++){
            helper(s, i, i);
            helper(s, i, i+1);
        }
        return s.substring(l, r + 1);
        
    }

    public void helper(String s, int i, int j){
        if(i < 0 || j >= s.length() || s.charAt(i) != s.charAt(j)){
            return;
        }
        helper(s, i-1, j+1);
        if(j-i > max){
            max = j-i;
            l = i;
            r = j;
        }
    }
}
