class Solution {
    public int triangularSum(int[] nums) {
        List<Integer> list = new ArrayList();
        for(int item: nums) {
            list.add(item);
        }
        while (list.size() != 1) {
            List<Integer> newList = new ArrayList();
            for (int i=1; i<list.size(); i++) {
                newList.add((list.get(i-1) + list.get(i)) % 10);
            } 
            list = newList;
        }
        
        return list.get(0);
        
    }
}