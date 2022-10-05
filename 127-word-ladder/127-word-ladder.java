class Pair {
    String word;
    int steps;
    
    Pair (String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for (String word: wordList) {
            wordSet.add(word);
        }
        
        Queue<Pair> queue = new LinkedList<>();
        
        queue.add(new Pair(beginWord, 1));
        
        
        while (!queue.isEmpty()) {
            Set<String> newWordSet = new HashSet<>(wordSet);
            Pair pair = queue.poll();
            String currentWord = pair.word;
            int steps = pair.steps;
            
            for (String word: wordSet) {
                if (diff(currentWord, word)) {
                    if (word.equals(endWord)) {
                        return steps+1;
                    } else {
                        // System.out.println("Adding " + word + " : " + (steps+1));
                        queue.add(new Pair(word, steps+1));
                        newWordSet.remove(word);
                    }
                }
            }
            
            wordSet = newWordSet;
        }
        
        return 0;
    }
    
    private boolean diff(String word1, String word2) {
        boolean oneUsed = false;
        for (int i=0; i<word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (oneUsed) {
                    return false;
                } else {
                    oneUsed = true;
                }
            }
        }
        
        return true;
    }
}