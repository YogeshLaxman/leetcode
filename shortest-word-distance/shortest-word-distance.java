class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int n = words.length;
        int min = Integer.MAX_VALUE;
        
        int lastWord1Index = -1;
        int lastWord2Index = -1;
        
        for(int i=0; i<n; i++) {
            if (words[i].equals(word1)) {
                if (lastWord2Index != -1) {
                    min = Math.min(min, i - lastWord2Index);
                }
                lastWord1Index = i;
            }    
            
            if (words[i].equals(word2)) {
                if (lastWord1Index != -1) {
                    min = Math.min(min, i - lastWord1Index);
                }
                lastWord2Index = i;
            }
        }
        
        return min;
    }
}