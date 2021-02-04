class Item {
    int start;
    int end;
    int count;
    
    Item(int s, int e, int c) {
        start = s;
        end = e;
        count = c;
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Item> startMap = new HashMap<>();
        Map<Integer, Item> endMap = new HashMap<>();
        
        Set<Integer> seen = new HashSet<>();
        int max = 0;
        for (int num : nums) {
            if (seen.contains(num)) {
                continue;
            }
            seen.add(num);
            Item lessItem = endMap.getOrDefault(num-1, null);
            Item moreItem = startMap.getOrDefault(num+1, null);
            
            int current = 0;
            if (lessItem == null && moreItem == null) {
                Item item = new Item(num, num, 1);
                startMap.put(num, item);
                endMap.put(num, item);
                current = 1;
            } else if (lessItem != null && moreItem != null) {
                Item item = new Item(lessItem.start, moreItem.end, lessItem.count+moreItem.count+1);
                startMap.remove(lessItem.start);
                endMap.remove(lessItem.end);
                startMap.remove(moreItem.start);
                endMap.remove(moreItem.end);
                
                startMap.put(item.start, item);
                endMap.put(item.end, item);
                
                current = item.count;
            } else if (lessItem != null) {
                endMap.remove(num-1);
                lessItem.end = num;
                lessItem.count++;
                endMap.put(num, lessItem);
                current = lessItem.count;
            } else {
                startMap.remove(num+1);
                moreItem.start = num;
                moreItem.count++;
                startMap.put(num, moreItem);
                current = moreItem.count;
            }
            
            max = Math.max(current, max);
        }
        
        return max;
        
    }
}