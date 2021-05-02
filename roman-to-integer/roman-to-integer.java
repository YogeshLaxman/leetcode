class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap();
        map.put('I', 1); 
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        char prev = '?';
        int ans = 0;
        for (char c: s.toCharArray()) {
            if (prev == 'I' && (c == 'V' || c == 'X')) {
                ans -= 1;
                ans += map.get(c) - 1;
            } else if (prev == 'X' && (c == 'L' || c == 'C')) {
                ans -= 10;
                ans += map.get(c) - 10;
            } else if (prev == 'C' && (c == 'D' || c == 'M')) {
                ans -= 100;
                ans += map.get(c) - 100;
            } else {
                ans += map.get(c);
            }
            prev = c;
        }
        
        return ans;
    }
}