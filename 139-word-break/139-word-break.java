class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];    // dp[i] = if possible to use words from wordDict to make s up to index i
               // array is initialize  to null to indicate not calculated yet
        
        return wordBreak(s, 0, wordDict, dp);
    }
    
    private boolean wordBreak(String s,int index,List<String> dict,Boolean[] present){
        int wordLength= s.length();
        if(index>=wordLength){
            return true;
        }
        Boolean isPresent = present[index];
        if(isPresent!=null){
            return isPresent;
        }
        boolean mark = false;
        for(int i=0;i<dict.size();i++){
            String word = dict.get(i);
            if(s.startsWith(word,index) && wordBreak(s,index+word.length(),dict,present)){
                mark=true;
                break;
            }
        }
        present[index]=mark;
        return mark;    
    }
}