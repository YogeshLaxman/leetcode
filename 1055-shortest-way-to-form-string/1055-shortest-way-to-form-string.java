class Solution {
    public int shortestWay(String source, String target) {
        int current = 0;
        int count = 1;
        for (int i=0; i<target.length(); i++) {
            
            boolean charFound = false;
            while (current < source.length()) {
                if (source.charAt(current) == target.charAt(i)) {
                    current++;
                    charFound = true;
                    break;
                }
                current++;
            }
            
            if (!charFound) {
                current = 0;
                count++;
                
                while (current < source.length()) {
                    if (source.charAt(current) == target.charAt(i)) {
                        current++;
                        charFound = true;
                        break;
                    }
                    current++;
                }
            }
            
            if (!charFound) {
                return -1;
            }
            
        }
        
        return count;
    }
}