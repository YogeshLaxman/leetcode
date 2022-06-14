class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> dependentOn = new ArrayList<>();
        List<Set<Integer>> ultaGraph = new ArrayList<>();
        
        for (int i=0; i<numCourses; i++) {
            dependentOn.add(0);
            ultaGraph.add(new HashSet<>());
        }
        
        for (int[] pre: prerequisites) {
            dependentOn.set(pre[0], dependentOn.get(pre[0]) + 1);
            ultaGraph.get(pre[1]).add(pre[0]);
        }
        
        Queue<Integer> queue = new LinkedList();
        for (int i=0; i<numCourses; i++) {
            if (dependentOn.get(i) == 0) {
                queue.add(i);
            }
        }
        
        int done = 0;
        while (!queue.isEmpty()) {
            int nextDone = queue.poll();
            done++;
            
            Set<Integer> dependentCourses = ultaGraph.get(nextDone);
            for (int c: dependentCourses) {
                dependentOn.set(c, dependentOn.get(c) - 1);
                if (dependentOn.get(c) == 0) {
                    queue.add(c);
                }
            }
        }
        
        return done == numCourses;
    }
}