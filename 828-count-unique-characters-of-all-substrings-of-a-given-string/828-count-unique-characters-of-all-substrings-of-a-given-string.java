class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        int[][] array = new int [26][2];
        
        int sum = 0; 
        int prev = 0;
        for (int i=n-1; i>=0; i--) {
            char ch = s.charAt(i);
            if (array[ch-'A'][0] == 0) {
                array[ch-'A'][0] = i;
                array[ch-'A'][1] = n - i;
                
                prev = (prev + array[ch-'A'][1]);
                sum += prev;
                
            } else {
                int lastIndex = array[ch-'A'][0];
                int lastAddition = array[ch-'A'][1];
                
                int currentAddition = lastIndex - i;
                
                prev = (prev + currentAddition - lastAddition);
                sum += prev;
                
                array[ch-'A'][0] = i;
                array[ch-'A'][1] = currentAddition;
            }
        }
        
        return sum;
    }
}