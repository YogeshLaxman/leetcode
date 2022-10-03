class Solution {
    public long numberOfWays(String s) {
        int total0 = 0;
        int total1 = 0;
        
        for (char c: s.toCharArray()) {
            if (c == '0') {
                total0++;
            } else {
                total1++;
            }
        }
        
        long sum = 0;
        
        int total0C = 0;
        int total1C = 0;
        for (char c: s.toCharArray()) {
            if (c == '0') {
                total0C++;
                sum += 1l * total1C * (total1 - total1C);
            } else {
                total1C++;
                sum += 1l * total0C * (total0 - total0C);
            }
        }
        
        return sum;
    }
}