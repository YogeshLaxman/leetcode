class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<String, Integer> gridMap = new HashMap<>();
        
        for (int i=0; i<artifacts.length; i++) {
            int r1i = artifacts[i][0];
            int c1i = artifacts[i][1];
            int r2i = artifacts[i][2];
            int c2i = artifacts[i][3];
            
            int count = 0;
            for (int j=r1i; j<=r2i; j++) {
                for (int k=c1i; k<=c2i; k++) {
                    count++;
                    gridMap.put(j+":"+k, i);
                }
            }
            countMap.put(i, count);
        }
        
        
        int empty = 0;
        for (int[] item: dig) {
            String key = item[0]+":"+item[1];
            if (gridMap.containsKey(key)) {
                int gridKey = gridMap.get(key);
                countMap.put(gridKey, countMap.get(gridKey) - 1);
                if (countMap.get(gridKey) == 0) {
                    empty++;
                }
            }
        }
        
        return empty;
    }
}