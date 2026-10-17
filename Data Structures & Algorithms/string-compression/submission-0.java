class Solution {
    public int compress(char[] chars) {
        int i = 0, k = 0;
        int n = chars.length;
        while (i < n) {
            char ch = chars[i];
            int count = 0;

            while (i < n && ch == chars[i]) {
                i++;
                count++;
            }
            chars[k++] = ch;
            if (count > 1) {
                for (char digit : String.valueOf(count).toCharArray()) {
                    chars[k++] = digit;
                }
            }
        }

        return k;
    }
}