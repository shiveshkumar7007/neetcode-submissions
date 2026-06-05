class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }
        int count = 0;
        int left = 0;
        int start = 0;
        int end = 0;
        int minlen = Integer.MAX_VALUE;
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                if(map.get(c) >= 0){
                    count++;
                }
            }

            while(t.length() == count){
                if(right-left+1 < minlen){
                    minlen = right-left+1;
                    start = left;
                }

                char leftchar = s.charAt(left);
                if(map.containsKey(leftchar)){
                    map.put(leftchar, map.get(leftchar) + 1);
                    if(map.get(leftchar) > 0){
                        count--;
                    }
                }
                left++;
            }
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start, start + minlen);
        
    }
}
