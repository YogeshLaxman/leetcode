class Node {
    Set<String> words;
    Node[] childNodes;
    
    Node() {
        words = new HashSet<>();
        childNodes = new Node[26];
    }
}
class Trie {
    Node root;
    
    Trie() {
        root = new Node();
    }
    
    public void add(String word) {
        this.add(word, 0, root);
    }
    
    public void add(String word, int index, Node node) {
        if (index == word.length()) {
            node.words.add(word);
            return;
        }
        
        char currentChar = word.charAt(index);
        int currentCharIndex = currentChar - 'a';
        if (node.childNodes[currentCharIndex] == null) {
            node.childNodes[currentCharIndex] = new Node();
        }
        
        add(word, index+1, node.childNodes[currentCharIndex]);
    }
}

class Solution {
    Set<String> ans;
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        ans = new HashSet<>();
        
        for (String word: words) {
            trie.add(word);
        }
        
        int m = board.length, n = board[0].length;
        boolean[][] seen = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                seen[i][j] = true;
                findWords(board, trie.root, seen, i, j);
                seen[i][j] = false;
            }
        }
        
        return new ArrayList<>(ans);
    }
    
    private void findWords(char[][] board, Node parent, boolean[][] seen , int i, int j) {
        if (parent == null) return;
        
        int currentIndex = board[i][j] - 'a';
        if (parent.childNodes[currentIndex] == null) {
            return;
        } 
        
        Node newParent = parent.childNodes[currentIndex];
        ans.addAll(newParent.words);
        
        int m = board.length, n = board[0].length;
        
        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        
        for (int[] dir: directions) {
            int x = i + dir[0], y = j + dir[1];
            
            if (x >= 0 && x < m && y >= 0 && y < n && !seen[x][y]) {
                seen[x][y] = true;
                findWords(board, newParent, seen, x, y);
                seen[x][y] = false;
            }
        }
    }
}