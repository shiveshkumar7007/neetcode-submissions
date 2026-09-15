class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0;
        char[] ch = s.toCharArray();
        int res = 0;
        int maxFreq = 0;
        int[] freq = new int[26];
        for(int j = 0; j < s.length(); j++){
            int ind = ch[j]- 'A';
            freq[ind]++;
            maxFreq = Math.max(freq[ind], maxFreq);
            while(j-i+1 - maxFreq > k){
                freq[ch[i] - 'A']--;
                i++;
            }
            res = Math.max(res, j-i+1);
        }
        return res;
    }
}
