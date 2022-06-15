class Node {
    int startNumber;
    int endNumber;
    
    Node(int s, int e) {
        this.startNumber = s;
        this.endNumber = e;
    }
    
    int numberOfNodes() {
        return endNumber - startNumber + 1;
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        
        Map<Integer, Node> startsWithMap = new HashMap<>();
        Map<Integer, Node> endsWithMap = new HashMap<>();
        
        for (int num: nums) {
            if (seen.contains(num)) {
                continue;
            }
            
            Node node = new Node(num, num);
            
            if (startsWithMap.containsKey(num+1)) {
                Node startsWithNode = startsWithMap.get(num+1);
                startsWithMap.remove(num+1);
                
                node.endNumber = startsWithNode.endNumber;
                startsWithMap.put(num, node);
            } else {
                startsWithMap.put(num, node);
            }
            
            if (endsWithMap.containsKey(num-1)) {
                Node endWithNode = endsWithMap.get(num-1);
                
                endsWithMap.remove(num-1);
                startsWithMap.remove(num);
                
                node.startNumber = endWithNode.startNumber;
                
                startsWithMap.put(node.startNumber, node);
                endsWithMap.put(node.endNumber, node);
            } else {
                endsWithMap.put(node.endNumber, node);
            }
            
            seen.add(num);
        }
        
        int max = 0;
        for (Map.Entry<Integer, Node> entry: startsWithMap.entrySet()) {
            // System.out.println(entry.getValue().startNumber + ":" + entry.getValue().endNumber);
            max = Math.max(max, entry.getValue().numberOfNodes());
        }
        
        //Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        return max;
    }
    
    /*
        100
        200    
        1, 2, 3, 4
    */
}