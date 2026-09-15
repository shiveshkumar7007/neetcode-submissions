class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        int[] need = new int[128];
        int[] cur = new int[128];

        for (char ch : t.toCharArray()) {
            need[ch]++;
        }

        int i = 0;
        int st = 0;
        int e = 0;
        int len = Integer.MAX_VALUE;

        int have = 0;

        for (int j = 0; j < s.length(); j++) {

            char ch = s.charAt(j);

            if (need[ch] != 0) {
                cur[ch]++;

                if (cur[ch] <= need[ch]) {
                    have++;
                }
            }

            while (have == t.length()) {

                if (j - i + 1 < len) {
                    len = j - i + 1;
                    st = i;
                    e = j;
                }

                char left = s.charAt(i);

                if (need[left] != 0) {

                    if (cur[left] <= need[left]) {
                        have--;
                    }

                    cur[left]--;
                }

                i++;
            }
        }

        if (len == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(st, e + 1);
    }
}