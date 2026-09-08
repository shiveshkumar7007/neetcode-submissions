public class Node {
    Node[] child = new Node[26];
    boolean eow = false;
}

public class Trie {
    Node root = new Node();

    public void addWord(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (cur.child[i] == null) {
                cur.child[i] = new Node();
            }
            cur = cur.child[i];
        }
        cur.eow = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (cur.child[i] == null) {
                return false;
            }
            cur = cur.child[i];
        }
        return cur.eow;
    }
}

class Solution {
    Trie trie = new Trie();
    int[] dp;
    public int minExtraChar(String s, String[] dictionary) {
        for (String word : dictionary) {
            trie.addWord(word);
        }

        dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return helper(s, 0);
    }

    public int helper(String s, int i) {
        if (i == s.length()) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }

        // Consider s[i] as an extra character
        int ans = 1 + helper(s, i + 1);

        Node cur = trie.root;

        // Try every dictionary word starting from i
        for (int j = i; j < s.length(); j++) {
            String word = s.substring(i, j + 1);

            if (trie.search(word)) {
                ans = Math.min(ans, helper(s, j + 1));
            }
        }

        return dp[i] = ans;
    }
}