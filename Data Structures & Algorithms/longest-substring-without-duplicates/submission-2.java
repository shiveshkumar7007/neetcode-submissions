class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        int len = 0;
        char[] ch = s.toCharArray();
        for(int j = 0; j < s.length(); j++){
            while(set.contains(ch[j])){
                set.remove(ch[i]);
                i++;
            }
            len = Math.max(len, j-i+1);

            set.add(ch[j]);

        }

        return len;
    }
}
