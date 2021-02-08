class Solution {
    List<String> ans = new ArrayList<>();
    Map<Character, List<Character>> telephone;
    public  void letterCombinations(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        char ch = digits.charAt(index);
        List<Character> list = telephone.get(ch);
        
        for(char next: list) {
            StringBuilder combination = new StringBuilder(sb);
            combination.append(next);
            letterCombinations(digits, index+1, combination);
        }
        
    }
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return ans;
        }
        telephone = new HashMap<>();
        telephone.put('2', Arrays.asList('a', 'b', 'c'));
        telephone.put('3', Arrays.asList('d', 'e', 'f'));
        telephone.put('4', Arrays.asList('g', 'h', 'i'));
        telephone.put('5', Arrays.asList('j', 'k', 'l'));
        telephone.put('6', Arrays.asList('m', 'n', 'o'));
        telephone.put('7', Arrays.asList('p', 'q', 'r', 's'));
        telephone.put('8', Arrays.asList('t', 'u', 'v'));
        telephone.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        
        letterCombinations(digits, 0, new StringBuilder(""));
        return ans;
    }
}