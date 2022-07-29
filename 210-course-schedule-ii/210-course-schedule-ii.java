class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, Set<Integer>> dependencyMap = new HashMap<>();
        
        for (int i=0; i<numCourses; i++) {
            dependencyMap.put(i, new HashSet<>());
        }
        
        for (int[] prerequisite : prerequisites) {
            dependencyMap.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i=0; i<numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);    
            }
            
        }
        
        int[] ans = new int[numCourses];
        int index = 0;
        
        while (!queue.isEmpty()) {
            int next = queue.poll();
            ans[index++] = next;
            
            for (int dependent: dependencyMap.get(next)) {
                inDegree[dependent]--;
                if (inDegree[dependent] == 0) {
                    queue.add(dependent);
                }
            }
        }
        
        return index != numCourses ? new int[0] : ans;
    }
}