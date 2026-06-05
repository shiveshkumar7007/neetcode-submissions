class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        for(int i = 0; i < s.length(); i++){
            helper(s, i, i);
            helper(s, i, i+1);
        }
        return count;
    }

    public void helper(String s, int i, int j){
        if(i < 0 || j >= s.length() || s.charAt(i) != s.charAt(j)){
            return;
        }

        count++;
        helper(s, i-1, j+1);

    }
}
