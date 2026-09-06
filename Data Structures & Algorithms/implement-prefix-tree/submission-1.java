public class Node {
    Node[] child = new Node[26];
    boolean eow = false;
}

class PrefixTree {
    public Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
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

    public boolean startsWith(String prefix) {
        Node cur = root;

        for (char ch : prefix.toCharArray()) {
            int i = ch - 'a';
            if (cur.child[i] == null) {
                return false;
            }
            cur = cur.child[i];
        }
        return true;
    }
}
