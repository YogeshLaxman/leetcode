class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        
        for (char c: s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<26; i++) {
            int current = freq[i];
            if (set.contains(current)) {
                while(set.contains(current)) {
                    if (current == 0) {
                       break;
                    }
                    current--;
                    count++;
                }
            }
            set.add(current);
        }
        return count;
    }
}