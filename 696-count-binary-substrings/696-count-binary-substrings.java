class Solution {
    public int countBinarySubstrings(String s) {
        boolean isZero = s.charAt(0) == '0';
        int count = 0;
        
        int lastCount = 0;
        
        int currentIndex = 0;
        
        int sum = 0;
        while (currentIndex < s.length()) {
            boolean isCurrentZero = s.charAt(currentIndex) == '0';
            
            if (isCurrentZero == isZero) {
                count++;
            } else {
                
                sum += Math.min(lastCount, count);
                lastCount = count;
                
                isZero = !isZero;
                count = 1;
                // System.out.println(currentIndex + ":" + sum);
            }
            currentIndex++;
        }
        
        sum += Math.min(lastCount, count);
        
        return sum;
    }
}