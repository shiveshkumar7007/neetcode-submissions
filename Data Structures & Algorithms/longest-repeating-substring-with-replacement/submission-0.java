class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l = 0, maxFreq = 0, res = 0;

        for(int r = 0; r < s.length(); r++){
            char ch = s.charAt(r);
            freq[ch - 'A']++;
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            while((r - l + 1) - maxFreq > k){
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
