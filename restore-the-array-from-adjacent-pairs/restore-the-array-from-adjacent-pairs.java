class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int[] ans = new int[adjacentPairs.length+1];
        
        Set<Integer> seen = new HashSet<>();
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int[] pair: adjacentPairs) {
            int e1 = pair[0];
            int e2 = pair[1];
            if (seen.contains(e1)) {
                seen.remove(e1);
            } else {
                seen.add(e1);
            }
            if (seen.contains(e2)) {
                seen.remove(e2);
            } else {
                seen.add(e2);
            }
            LinkedList<Integer> list1 = map.getOrDefault(e1, new LinkedList<>());
            LinkedList<Integer> list2 = map.getOrDefault(e2, new LinkedList<>());
            
            list1.add(e2);
            list2.add(e1);
            
            map.put(e1, list1);
            map.put(e2, list2);
        }
        
        List<Integer> list = new ArrayList<>(seen);
        ans[0] = list.get(0);
        
        for (int i=1; i<=adjacentPairs.length; i++) {
            int add = map.get(ans[i-1]).getFirst();
            ans[i] = add;
            map.get(ans[i-1]).removeFirst();
            map.get(add).remove((Integer) ans[i-1]);
        }
        
        return ans;
    }
}