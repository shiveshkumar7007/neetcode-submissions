class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] need = new int[128];   
        int[] have = new int[128];   

        for (char ch : t.toCharArray()) {
            need[ch]++;
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int required = t.length();
        
        while (right < s.length()) {
            char rChar = s.charAt(right);
            
            if (need[rChar] > 0) { 
                if (have[rChar] < need[rChar]) {
                    required--;
                }
                have[rChar]++;
            }
            right++;

            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }

                char lChar = s.charAt(left);
                if (need[lChar] > 0) {
                    have[lChar]--;
                    if (have[lChar] < need[lChar]) {
                        required++;
                    }
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
