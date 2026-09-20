class Solution {
    class Pair {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> y.freq - x.freq);
        if(a > 0){
            pq.add(new Pair('a', a));
        }
        if(b > 0){
            pq.add(new Pair('b', b));
        }
        if(c > 0){
            pq.add(new Pair('c', c));
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            Pair first = pq.poll();
            int n = sb.length();

            if(n >= 2 && sb.charAt(n-1) == first.ch && sb.charAt(n-2) == first.ch){
                if (pq.isEmpty()){
                    break;
                }

                Pair second = pq.poll();
                sb.append(second.ch);
                second.freq--;
                if(second.freq > 0){
                    pq.add(second);
                }
                pq.add(first);
            } else{
                sb.append(first.ch);
                first.freq--;
                if(first.freq > 0){
                    pq.add(first);
                }
            }

        }

        return sb.toString();

    }
}