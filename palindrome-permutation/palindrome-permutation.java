class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        boolean firstOdd = false;
        for(int num: map.values()) {
            if (num % 2 == 1) {
                if (firstOdd) {
                    return false;    
                } else {
                    firstOdd = true;
                }
                
            }
        }
        return true;
    }
}