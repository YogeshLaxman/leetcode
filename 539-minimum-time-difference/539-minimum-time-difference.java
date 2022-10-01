class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> list = new ArrayList<>();
        
        for (String time: timePoints) {
            int h = Integer.parseInt(time.substring(0,2));
            int m = Integer.parseInt(time.substring(3));
            
            list.add(h*60 + m);
        }
        
        Collections.sort(list);
        
        list.add(24*60 + list.get(0));
        
        int min = Integer.MAX_VALUE;
        for (int i=1; i<list.size(); i++) {
            int diff = list.get(i) - list.get(i-1);
            min = Math.min(min, diff);
        }
        
        return min;
    }
}