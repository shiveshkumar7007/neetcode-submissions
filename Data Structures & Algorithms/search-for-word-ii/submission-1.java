public class Node {
    Node[] child = new Node[26];
    boolean eow = false;
}

public class Trie {
    Node root = new Node();

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
}

class Solution {
    Trie trie = new Trie();
    List<String> res = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            trie.insert(word);
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, trie.root, "");
            }
        }

        return res;

    }

    public void dfs(char[][] board, int r, int c, Node cur, String word){
        int n = board.length;
        int m = board[0].length;
        if(r < 0 || r >= n || c < 0 || c >= m || board[r][c] == '#'){
            return;
        }

        int i = board[r][c] - 'a';

        if(cur.child[i] == null){
            return;
        }

        cur = cur.child[i];
        word += board[r][c];

        if(cur.eow){
            res.add(word);
            cur.eow = false;
        }

        char temp = board[r][c];
        board[r][c] = '#';

        dfs(board, r + 1, c, cur, word);
        dfs(board, r - 1, c, cur, word);
        dfs(board, r, c + 1, cur, word);
        dfs(board, r, c - 1, cur, word);

        board[r][c] = temp;
    }
}
