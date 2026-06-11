class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(String s, int index, List<String> curr, List<List<String>> res){
        if(index == s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = index; i < s.length(); i++){
            String part = s.substring(index, i+1);
            if(isPallindrome(part)){
                curr.add(part);
                backtrack(s, i+1, curr, res);
                curr.remove(curr.size()-1);
            }
        }
    }

    public boolean isPallindrome(String s){
        int r = s.length()-1;
        int l = 0;{
            while(l < r){
                if(s.charAt(l) != s.charAt(r)){
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }
}
