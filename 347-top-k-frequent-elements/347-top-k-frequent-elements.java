class Element {
    int number;
    int frequency;
    
    Element(int n, int f) {
        this.number = n;
        this.frequency = f;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        for (int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        
        // 1, 1, 2, 3
        Element[] elements = new Element[freqMap.size()];
        int index=0;
        for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            elements[index++] = new Element(entry.getKey(), entry.getValue());
            // System.out.println(elements[index-1].number + ":" + elements[index-1].frequency);
        }
        
        quickSelect(elements, 0, elements.length-1, k-1);
        
        int[] ans = new int[k];
        for (int i=0; i<k; i++) {
            ans[i] = elements[i].number;
        }
        
        return ans;
    }
    
    private void quickSelect(Element[] elements, int low, int high, int k) {
        // System.out.println(low + ":" + high + ":" + k);
        int index = partition(elements, low, high);
        if (index == k) return;
        if (index > k) quickSelect(elements, low, index-1, k);
        if (index < k) quickSelect(elements, index+1, high, k);
    }
    
    private int partition(Element[] elements, int low, int high) {
        
        if (low == high) return low;
        int i = low + 1, j = high;
        
        // 3, 3, 3
        while (i < j) {
            
            while (i <= j && elements[i].frequency > elements[low].frequency) i++;

            while (i < j && elements[j].frequency <= elements[low].frequency) j--;

            if (i < j) {
                swap(elements, i, j);    
            }
        }
        
        swap(elements, low, i-1);
        
        return i-1;
    }
    
    private void swap(Element[] elements, int i, int j) {
        Element temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
}