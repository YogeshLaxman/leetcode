class Solution {
    public int maxFrequency(int[] nums, int k) {
        Map<Integer, Integer> countMap = new TreeMap<>();
        
        for (int item: nums) countMap.put(item, countMap.getOrDefault(item, 0) + 1);
        
        List<Map.Entry<Integer, Integer>> items = new ArrayList<>(countMap.entrySet());
        
        int max = 0;
        for (int i=0; i<items.size(); i++) {
            int rem = k;
            int count = items.get(i).getValue();
            for (int j=i-1; j>=0; j--) {
                int cost = items.get(j).getValue() * (items.get(i).getKey() - items.get(j).getKey());
                if (cost >= rem) {
                    count += rem / (items.get(i).getKey() - items.get(j).getKey());
                    break;
                }
                
                count += items.get(j).getValue();
                
                rem -= cost;
            }
            // System.out.println(items.get(i) + ":" + count);
            max = Math.max(max, count);
        }
        return max;
    }
}