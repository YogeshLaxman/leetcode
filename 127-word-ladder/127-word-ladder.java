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
        Map<String, Set<String>> wordMap = new HashMap<>();
        for (String word: wordList) {
            Set<String> possibleWords = getAllPossibleStrings(word);
            for (String possibleWord: possibleWords) {
                if (!wordMap.containsKey(possibleWord)) {
                    wordMap.put(possibleWord, new HashSet<>());
                }
                wordMap.get(possibleWord).add(word);
            }
        }
        
        Queue<Pair> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        
        queue.add(new Pair(beginWord, 1));
        seen.add(beginWord);
        
        
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String currentWord = pair.word;
            int steps = pair.steps;
            
            Set<String> possibleWords = getAllPossibleStrings(currentWord);
            for (String possibleWord: possibleWords) {
                for (String word: wordMap.getOrDefault(possibleWord, new HashSet<>()))
                    if (!seen.contains(word)) {
                        if (word.equals(endWord)) {
                            return steps+1;
                        } else {
                            // System.out.println("Adding " + word + " : " + (steps+1));
                            queue.add(new Pair(word, steps+1));
                            seen.add(word);
                        }
                    }
            }
        }
        
        return 0;
    }
    
    private Set<String> getAllPossibleStrings(String word) {
        StringBuilder sb = new StringBuilder(word);
        
        Set<String> ans = new HashSet<>();
        for (int i=0; i<word.length(); i++) {
            sb.setCharAt(i, '*');
            ans.add(sb.toString());
            sb.setCharAt(i, word.charAt(i));
        }
        
        return ans;
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