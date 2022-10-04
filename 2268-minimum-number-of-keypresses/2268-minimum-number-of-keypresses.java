class Solution {
    public int minimumKeypresses(String s) {
        int[] freqMap = new int[26];
        
        for (char c: s.toCharArray()) {
            freqMap[c-'a']++;
        }
        
        Arrays.sort(freqMap);
        
        int count = 0;
        for (int i=0; i<8; i++) {
            count += 3 * freqMap[i];
        }
        
        for (int i=8; i<17; i++) {
            count += 2 * freqMap[i];
        }
        
        for (int i=17; i<26; i++) {
            count += 1 * freqMap[i];           
        }
        
        return count;
    }
}