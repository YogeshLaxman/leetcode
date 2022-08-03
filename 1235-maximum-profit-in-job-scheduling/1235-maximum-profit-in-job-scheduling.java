class Item {
    int startTime;
    int endTime;
    int profit;
    
    Item(int s, int e, int p) {
        startTime = s;
        endTime = e;
        profit = p;
    }
}

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Item[] items = new Item[n];        
        
        for (int i=0; i<n; i++) {
            items[i] = new Item(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(items, (a,b) -> a.startTime - b.startTime);
        
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return jobScheduling(items, 0, memo);
    }
    
    private int jobScheduling(Item[] items, int currentIndex, int[] memo) {
        int n = items.length;
        if (currentIndex == n) return 0;
        
        if (memo[currentIndex] != -1) return memo[currentIndex];
        int ans = jobScheduling(items, currentIndex+1, memo);
        
        int anotherPossibleAns = items[currentIndex].profit;
        for (int i=currentIndex; i<n; i++) {
            if (items[i].startTime >= items[currentIndex].endTime) {
                anotherPossibleAns += jobScheduling(items, i, memo);
                break;
            }
        }
        
        return memo[currentIndex] = Math.max(ans, anotherPossibleAns);
    }
}