class Solution {
    private int maxLength(List<String> arr, int index, boolean[] current, int count) {
        if (index == arr.size()) {
            return count;
        }
        
        boolean isUnique = true;
        boolean[] newState = new boolean[26];
        int newCount = count;
        for (int i=0 ;i<26; i++) {
            newState[i] = current[i];
        }
        for (char ch: arr.get(index).toCharArray()) {
            if (newState[ch-'a']) {
                isUnique = false;
            } else {
                newState[ch-'a'] = true;
                newCount++;
            }
        }
        
        if (isUnique) {
            return Math.max(maxLength(arr, index+1, current, count), maxLength(arr, index+1, newState, newCount));
        } else {
            return maxLength(arr, index+1, current, count);
        }
    }
    
    public int maxLength(List<String> arr) {
        boolean[] state = new boolean[26];
        return maxLength(arr, 0, state, 0);
    }
}