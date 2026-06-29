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
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.freq - x.freq);

        if (a > 0)
            pq.offer(new Pair('a', a));
        if (b > 0)
            pq.offer(new Pair('b', b));
        if (c > 0)
            pq.offer(new Pair('c', c));

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Pair first = pq.poll();
            int n = sb.length();

            // If adding this character creates 3 consecutive same letters
            if (n >= 2 && sb.charAt(n - 1) == first.ch && sb.charAt(n - 2) == first.ch) {
                // No other character available
                if (pq.isEmpty()){
                    break;
                }

                Pair second = pq.poll();

                sb.append(second.ch);
                second.freq--;

                if (second.freq > 0)
                    pq.offer(second);

                // Put the first character back
                pq.offer(first);

            } else {

                sb.append(first.ch);
                first.freq--;

                if (first.freq > 0){
                    pq.offer(first);
                }
            }
        }

        return sb.toString();
    }
}