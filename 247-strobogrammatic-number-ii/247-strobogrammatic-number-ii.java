class Solution {
    public List<String> findStrobogrammatic(int n) {
        return findStrobogrammatic(0, n-1, "", "");
    }
    
    private List<String> findStrobogrammatic(int i, int j, String firstHalf, String secondHalf) {
        // System.out.println(i + ":" + j);
        if (i > j) {
            List<String> ans = new ArrayList<>();
            ans.add(firstHalf + secondHalf);
            return ans;
        }
        
        if (i == j) {
            List<String> ans = new ArrayList<>();
            ans.add(firstHalf + "0" + secondHalf);
            ans.add(firstHalf + "1" + secondHalf);
            ans.add(firstHalf + "8" + secondHalf);
            return ans;
        }
        
        List<String> ans = new ArrayList<>();
        
        ans.addAll(findStrobogrammatic(i+1, j-1, firstHalf + "1", "1" + secondHalf));
        ans.addAll(findStrobogrammatic(i+1, j-1, firstHalf + "6", "9" + secondHalf));
        ans.addAll(findStrobogrammatic(i+1, j-1, firstHalf + "9", "6" + secondHalf));
        ans.addAll(findStrobogrammatic(i+1, j-1, firstHalf + "8", "8" + secondHalf));
        
        if (i != 0) {
            ans.addAll(findStrobogrammatic(i+1, j-1, firstHalf + "0", "0" + secondHalf));
        }
        
        return ans;
    }
    
}