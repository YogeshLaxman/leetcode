class Solution {
    
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        // System.out.println(tMap);
        for (int i=0; i<t.length(); i++) {
            char c = s.charAt(i);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        
        int left = 0;
        int right = t.length();
        int minLeft = 0;
        int minRight = s.length();
        if (isFound(sMap, tMap)) return s.substring(0, t.length());
        
        while (right < s.length()) {
            char c = s.charAt(right);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            
            if (isFound(sMap, tMap)) {
                while (left < right) {
                    char leftChar = s.charAt(left);
                    if (sMap.get(leftChar) - 1 >= tMap.getOrDefault(leftChar, 0)) {
                        sMap.put(leftChar, sMap.get(leftChar) - 1);
                        left++;
                    } else {
                        break;
                    }
                }
                int minLength = minRight - minLeft + 1;
                int curLength = right - left + 1;
                if (minLength > curLength) {
                    minRight = right;
                    minLeft = left;
                }
            }
            
            right++;
        }
        
        return (minRight - minLeft + 1 == s.length() + 1) ? "" : s.substring(minLeft, minRight+1);
    }
    
    private boolean isFound(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        // System.out.println(sMap);
        
        for (Map.Entry<Character, Integer> entry: tMap.entrySet()) {
            char k = entry.getKey();
            int v = entry.getValue();
            
            if (sMap.containsKey(k)) {
                if (v > sMap.get(k)) return false;
            } else {
                return false;
            }
        }
        
        return true;
    }
    
}