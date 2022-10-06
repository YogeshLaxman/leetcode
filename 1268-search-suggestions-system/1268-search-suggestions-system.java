class Node {
    List<String> words;
    Node[] children;
    
    Node() {
        words = new ArrayList<>();
        children = new Node[26];
    }
}

class Trie {
    Node root;
    
    Trie() {
        root = new Node();
    }
    
    void addWord(String word) {
        addWord(word, root, 0);
    }
    
    void addWord(String word, Node node, int index) {
        node.words.add(word);
        if (word.length() == index) {
            return;
        }
        
        int chIndex = word.charAt(index) - 'a';
        if (node.children[chIndex] == null) {
            node.children[chIndex] = new Node();
        }
        
        addWord(word, node.children[chIndex], index+1);
    }
    
    List<List<String>> SearchPrefix(String word) {
        List<List<String>> ans = new ArrayList<>();
        
        int chIndex = word.charAt(0) - 'a';
        if (root.children[chIndex] == null) {
            root.children[chIndex] = new Node();
        }
        SearchPrefix(word, root.children[chIndex], 1, ans);
        
        return ans;
    }
    
    void SearchPrefix(String word, Node node, int index, List<List<String>> ans) {
        ans.add(node.words.size() > 3 ? node.words.subList(0, 3) : node.words);
        if (index == word.length()) {
            return;
        }
        
        
        int chIndex = word.charAt(index) - 'a';
        if (node.children[chIndex] == null) {
            node.children[chIndex] = new Node();
        }
        
        SearchPrefix(word, node.children[chIndex], index+1, ans);
    }
}
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Trie trie = new Trie();
        
        for (String product: products) {
            trie.addWord(product);
        }
        
        return trie.SearchPrefix(searchWord);
    }
}