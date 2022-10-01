class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();
        
        if (finalSum % 2 == 1) 
            return new ArrayList<>();;
        
        long current = 2;
        long totalSum = 0;
        
        while (totalSum + current <= finalSum) {
            ans.add(current);
            totalSum += current;
            current += 2;
        }
        
        if (totalSum < finalSum) {
            long last = ans.remove(ans.size()-1);
            ans.add(last + finalSum - totalSum);
        }
        
        return ans;
        
    }
}