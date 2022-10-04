class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] right = new int[n];
        
        int prev = 0;
        for (int i=n-1; i>=0; i--) {
            if (s.charAt(i) == '0') {
                right[i] = prev + 1;
            } else {
                right[i] = prev;
            }
            prev = right[i];
        }
        
        int min = Integer.MAX_VALUE;
        int numberOfOnes = 0;
        
        for (int i=0; i<n; i++) {
            int possibleMin = numberOfOnes + right[i];
            min = Math.min(min, possibleMin);
            
            if (s.charAt(i) == '1') {
                numberOfOnes++;
            }
        }
        
        min = Math.min(min, numberOfOnes);
        
        return min;
    }
}