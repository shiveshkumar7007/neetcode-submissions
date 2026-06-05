class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        s = s.toLowerCase();
        int l = 0;
        int r = len-1;
        while(l < r){
            if(!Character.isLetterOrDigit(s.charAt(l))){
                l++;
                continue;
            }
            else if(!Character.isLetterOrDigit(s.charAt(r))){
                r--;
                continue;
            }
            else if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;

        }
        return true;
    }
}
