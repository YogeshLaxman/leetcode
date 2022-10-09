class Solution {
    int[] memo;
    public int deleteString(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return deleteString(s, 0);
    }
    
    public int deleteString(String s, int startIndex) {
        // System.out.println(startIndex);
        
        int maxOperations = 1;
        if (memo[startIndex] != -1) {
            return memo[startIndex];
        }
        
        int[] kmpArray = getKmpPrefixArray(s, startIndex);
        // System.out.println(Arrays.toString(kmpArray));
        
        for (int i = startIndex + 1; i <= s.length(); i++) {
            boolean matched = false;
            
            int size = i - startIndex;
            // System.out.println(i+size-1);
            if (i+size-1 < s.length() && kmpArray[i+size-1] >= size && kmpArray[i] == 1) {
                matched = true;
            }

            if (matched) {
                // System.out.println("Calling: " + i + "From :" + startIndex);
                maxOperations = Math.max(1 + deleteString(s, i), maxOperations);
            }
        }
        
        return memo[startIndex] = maxOperations;
    }
    
    private int[] getKmpPrefixArray(String s, int index) {
        int n = s.length();
        int[] prefixArray = new int[n];
        
        for (int i=index+1; i < n; i++) {
            if (prefixArray[i-1] > 0) {
                int alreadyMatched = prefixArray[i-1];
                if (s.charAt(index+alreadyMatched) == s.charAt(i)) {
                    prefixArray[i] = alreadyMatched + 1;
                } else if (s.charAt(index) == s.charAt(i)) {
                    prefixArray[i] = 1;
                }
            } else {
                if (s.charAt(index) == s.charAt(i)) {
                    prefixArray[i] = 1;
                }
            }
        }
        
        return prefixArray;
    }
}