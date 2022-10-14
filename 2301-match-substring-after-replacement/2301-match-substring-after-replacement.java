class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (char[] mapping: mappings) {
            char old = mapping[0], newChar = mapping[1];
            if (!map.containsKey(old)) {
                map.put(old, new HashSet<>());
            }
            map.get(old).add(newChar);
        }
        
        for (int i=0; i < s.length() - sub.length() + 1; i++) {
            boolean possible = true;
            for (int j=0; j<sub.length(); j++) {
                char subChar = sub.charAt(j), sChar = s.charAt(i+j);
                if (sChar != subChar) {
                    if (!map.containsKey(subChar) || !map.get(subChar).contains(sChar)) {
                        possible = false;
                        break;
                    }
                }
            }
            if (possible) {
                return true;
            }
        }
        
        return false;
    }
}