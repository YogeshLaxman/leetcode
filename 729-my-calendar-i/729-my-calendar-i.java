class MyCalendar {
    
    List<int[]> intervalList;
    
    public MyCalendar() {
        intervalList = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        end--;
        int[] interval = new int[] {start, end};
        
        int index = Collections.binarySearch(intervalList, interval, (a, b) -> {
            return a[0] - b[0];
        });
        
        if (index >= 0) {
            return false;
        }
        
        index = (index * -1) - 1;
    
        
        if (index-1 >= 0) {
            if (intervalList.get(index-1)[1] >= start) {
                return false;
            }
        }
        
        if (index < intervalList.size()) {
            if (intervalList.get(index)[0] <= end) {
                return false;
            }
        }
        
        intervalList.add(index, interval);
        
        /* for (int[] item: intervalList) {
            System.out.print(Arrays.toString(item));
        }
        System.out.println(); */
        
        return true;
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */