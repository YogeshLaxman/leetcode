class Solution {
    List<List<String>> answer = new ArrayList<>();
    String endWord;
    Map<String, Set<String>> graph;
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.endWord = endWord;
        graph = new HashMap<>();
        
        for (String word: wordList) graph.put(word, new HashSet<>());
        graph.put(beginWord, new HashSet<>());
            
        if (!graph.containsKey(endWord))  return answer;
        
        int n = wordList.size();
        for (int i=0; i<n; i++) {
            String word1 = wordList.get(i);
            if (isDiff1(word1, beginWord)) graph.get(beginWord).add(word1);
            for (int j=i+1; j<n; j++) {
                String word2 = wordList.get(j);
                if (isDiff1(word1, word2)) {
                    graph.get(word1).add(word2);
                    graph.get(word2).add(word1);
                }
            }
        }
    
        findMinSequence(beginWord);
        
        return answer;
    }
    
    private boolean isDiff1(String word1, String word2) {
        int n = word1.length();
        int changes = 0;
        for (int i=0; i<n; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                changes++;
            }
        }       
        
        return changes == 1;
    }
    
    private void findMinSequence(String current) {
        Set<String> seen = new HashSet<>();
        
        Queue<Pair<String, List<String>>> q = new LinkedList<>();
        q.add(new Pair(current, Arrays.asList(current)));
        
        boolean found = false;
        while (!q.isEmpty() && !found) {
            int n = q.size();
            for (int i=0; i<n; i++) {
                Pair<String, List<String>> remove = q.poll();
                seen.add(remove.getKey());
                if (remove.getKey().equals(endWord)) {
                    found = true;
                    answer.add(remove.getValue());
                    continue;
                }
                Set<String> adjList = graph.get(remove.getKey());
                for (String item: adjList) {
                    if (!seen.contains(item)) {
                        List<String> newList = new ArrayList<>(remove.getValue());
                        newList.add(item);
                        q.add(new Pair(item, newList));
                    }
                }
            }
        }
        
        
    }
}