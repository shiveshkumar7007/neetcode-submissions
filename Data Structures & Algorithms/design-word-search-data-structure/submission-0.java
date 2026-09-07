public class Node {
    Node[] child = new Node[26];
    boolean eow = false;
}

class WordDictionary {
    public Node root;
    public WordDictionary() {
        root = new Node();
    }

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
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int j, Node root) {
        Node cur = root;

        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (Node child : cur.child) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (cur.child[c - 'a'] == null) {
                    return false;
                }
                cur = cur.child[c - 'a'];
            }
        }
        return cur.eow;
    }
}
