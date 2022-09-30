class Solution {
    public int shortestWay(String source, String target) {
        int m = source.length();
        
        
        int[][] memo = new int[m][26];
        
        Arrays.fill(memo[m-1], -1);
        memo[m-1][source.charAt(m-1) - 'a'] = m-1;
        
        for (int i=m-2; i>=0; i--) {
            for (int j=0; j<26; j++) {
                memo[i][j] = memo[i+1][j];
            }
            memo[i][source.charAt(i) - 'a'] = i;
        }
        
        int current = 0;
        int count = 1;
        
        for (int i=0; i<target.length(); i++) {
            
            boolean charFound = false;
            
            if (current == source.length()) {
                count++;
                current = 0;
            }
            
            int index = memo[current][target.charAt(i) - 'a'];
            
            
            if (index >= 0) {
                current = index+1;
                charFound = true;
            } else {
                current = 0;
                count++;
                
                index = memo[current][target.charAt(i) - 'a'];
                
                if (index >= 0) {
                    current = index+1;
                    charFound = true;
                }
            }
            
            if (!charFound) {
                return -1;
            }
        }
        
        return count;
    }
}