class Solution {
    public boolean isAnagram(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        if(l1 != l2){
            return false;
        }

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < l1; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)-1);
        }

        for(int value: map.values()){
            if(value != 0){
                return false;
            }
        }

        return true;

    }
}
