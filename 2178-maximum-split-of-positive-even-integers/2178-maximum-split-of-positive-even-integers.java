class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        Set<Long> ans = new HashSet<>();
        
        if (finalSum % 2 == 1) 
            return new ArrayList<>();;
        
        long current = 2;
        long totalSum = 0;
        
        while (totalSum < finalSum) {
            ans.add(current);
            totalSum += current;
            current += 2;
            
            if (totalSum > finalSum) {
                long diff = totalSum - finalSum;
                ans.remove(diff);
                totalSum = finalSum;
            }
        }
        
        return new ArrayList<>(ans);
        
    }
}