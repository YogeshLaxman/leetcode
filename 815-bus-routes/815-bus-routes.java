class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        int n = routes.length;
        boolean[] busRouteVisited = new boolean[n];
        
        Map<Integer, Set<Integer>> busRouteToBusStops = new HashMap<>();
        Map<Integer, Set<Integer>> busStopToBusRoutes = new HashMap<>();
        
        for (int i=0; i<routes.length; i++) {
            busRouteToBusStops.put(i, new HashSet<>());
            for (int j=0; j < routes[i].length; j++) {
                int stop = routes[i][j];
                busRouteToBusStops.get(i).add(stop);
                if (!busStopToBusRoutes.containsKey(stop)) {
                    busStopToBusRoutes.put(stop, new HashSet<>());
                }
                busStopToBusRoutes.get(stop).add(i);
            }
        }
        
        
        int ans = 1;
        Set<Integer> nextRoutesToExplore = busStopToBusRoutes.getOrDefault(target, new HashSet<>());
        while(nextRoutesToExplore.size() > 0) {
            Set<Integer> nextRoutesToExploreNext = new HashSet<>();
            for (int route: nextRoutesToExplore) {
                if (!busRouteVisited[route]) {
                    busRouteVisited[route] = true;
                    Set<Integer> stops = busRouteToBusStops.get(route);
                    if (stops.contains(source)) {
                        return ans;
                    }
                    for (int stop: stops) {
                        nextRoutesToExploreNext.addAll(busStopToBusRoutes.get(stop));
                    }
                    
                }
            }    
            nextRoutesToExplore = nextRoutesToExploreNext;
            ans++;
        }
        
        
        return -1;
    }
}