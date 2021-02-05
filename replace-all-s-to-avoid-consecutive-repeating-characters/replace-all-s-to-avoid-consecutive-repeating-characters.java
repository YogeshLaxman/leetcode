class Solution {
    public String modifyString(String s) {
        char[] charArray = s.toCharArray();
        
        for (int i=0; i<charArray.length; i++) {
            if (charArray[i] == '?') {
                char prev = i-1 < 0 ? 'A' : charArray[i-1];
                char next = i+1 >= charArray.length ? 'A' : charArray[i+1];
                
                for (int j=0; j<26; j++) {
                    char replacement = (char) ('a' + j);
                    if (prev != replacement && next != replacement) {
                        charArray[i] = replacement;
                        break;
                    }
                }
            }
        }
        
        return new String(charArray);
    }
}