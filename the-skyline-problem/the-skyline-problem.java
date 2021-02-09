class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(buildings, (a,b) -> {
            if (a[0] - b[0] == 0) {
                if (a[2] - b[2] == 0) {
                    return b[1] - a[1];
                }
                return b[2] - a[2];
            }
            return a[0] - b[0];
        });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (b[2] - a[2] == 0) {
                return b[1] - a[1];
            }
            return b[2] - a[2];
        });
        
        int currentHeight = 0;
        int currentEnd = buildings[0][0];
        int[] current = null;
        for(int[] bdg: buildings) {
            int xl = bdg[0];
            int xr = bdg[1];
            int h = bdg[2];
            
            while (currentEnd < xl && !pq.isEmpty()) {
                int[] item = pq.poll();
                if (item[1] > currentEnd) {
                    if (currentHeight == item[2] && currentEnd < item[1]) {
                        current = item;
                    } else {
                        ans.add(Arrays.asList(currentEnd, item[2]));
                        currentEnd = item[1];
                        currentHeight = item[2];
                        current = item;
                    }
                }
            }
            if (currentEnd < xl && pq.isEmpty()) {
                ans.add(Arrays.asList(currentEnd, 0));
                ans.add(Arrays.asList(xl, h));
                currentEnd = xr;
                currentHeight = h;
                current = bdg;
            } else if (currentHeight < h) {
                ans.add(Arrays.asList(xl, h));
                currentEnd = xr;
                currentHeight = h;
                if (current != null) {
                    pq.add(current);    
                }
                current = bdg;
            } else if (currentHeight == h && xr > currentEnd) {
                current = bdg;
                currentEnd = xr;
            } else {
                pq.add(bdg);
            }
        }
        
        while (!pq.isEmpty()) {
            int[] item = pq.poll();
            if (item[1] > currentEnd) {
                
                if (currentHeight != item[2]) {
                    
                    ans.add(Arrays.asList(currentEnd, item[2]));
                }

                currentEnd = item[1];
                currentHeight = item[2];
            }
        }
        ans.add(Arrays.asList(currentEnd, 0));
        
        return ans;
    }
}