class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> graph = new ArrayList<>();
        
        for (int i=0; i<numCourses; i++) {
            graph.add(new HashSet<>());
        }
        
        for (int[] pre: prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }
        
        Queue<Integer> queue = new LinkedList();
        for (int i=0; i<numCourses; i++) {
            if (graph.get(i).size() == 0) {
                queue.add(i);
            }
        }
        
        int done = 0;
        while (!queue.isEmpty()) {
            int nextDone = queue.poll();
            done++;
            for (int i=0; i<numCourses; i++) {
                if (graph.get(i).contains(nextDone)) {
                    graph.get(i).remove(nextDone);
                    if (graph.get(i).size() == 0) {
                        queue.add(i);
                    }
                }
            }
        }
        
        return done == numCourses;
    }
}