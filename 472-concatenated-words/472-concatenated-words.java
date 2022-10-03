class Node {
    boolean isWord;
    Node[] childern;
    
    Node() {
        childern = new Node[26];
    }
}

class Trie {
    Node root;
    
    Trie() {
        root = new Node();
    }
    
    void add(String word) {
        add(word, root, 0);
    }
    
    void add(String word, Node node, int index) {
        if (index == word.length()) {
            node.isWord = true;
            return;
        }
        
        char ch = word.charAt(index);
        if (node.childern[ch-'a'] == null) {
            node.childern[ch-'a'] = new Node();
        }
        
        add(word, node.childern[ch-'a'], index+1);
    }
    
    int breakAndFind(String word) {
        return breakAndFind(word, root, 0);
    }
    
    int breakAndFind(String word, Node node, int index) {
        if (node == null) {
            return 0;
        }
        
        if (index == word.length()) {
            return node.isWord ? 1 : 0;
        }
        
        int ans = 0;
        if (node.isWord) {
            ans += breakAndFind(word, root, index);
        }
        
        char ch = word.charAt(index);
        ans += breakAndFind(word, node.childern[ch-'a'], index+1);
        
        return ans;
    }
}

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie trie = new Trie();
        
        for (String word: words) {
            trie.add(word);
        }
        
        List<String> result = new ArrayList<>();
        for (String word: words) {
            int n = trie.breakAndFind(word);
            if (n > 1) {
                result.add(word);
            }
        }
        
        return result;
    }
}