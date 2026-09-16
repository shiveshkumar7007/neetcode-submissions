class TimeMap {
    class pair{
        String val;
        int timestamp;
        pair(String val, int timestamp){
            this.val = val;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<pair> list = map.get(key);
        int l = 0;
        int r = list.size()-1;
        String ans = "";

        while(l <= r){
            int mid = l + (r-l)/2;
            if(list.get(mid).timestamp <= timestamp){
                ans = list.get(mid).val;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        return ans;
    }
}
