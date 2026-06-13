class Solution {
    public boolean checkValidString(String s) {

        int low = 0;   // minimum possible open brackets
        int high = 0;  // maximum possible open brackets

        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                // definitely adds one open bracket
                low++;
                high++;

            } else if(ch == ')') {
                // definitely closes one bracket
                low--;
                high--;

            } else { // '*'
                // '*' can act as ')'
                low--;

                // '*' can act as '('
                high++;
            }
            // too many closing brackets
            if(high < 0) {
                return false;
            }
            // minimum open brackets can't be negative
            low = Math.max(low, 0);
        }
        // valid if we can end with 0 unmatched opens
        return low == 0;
    }
}