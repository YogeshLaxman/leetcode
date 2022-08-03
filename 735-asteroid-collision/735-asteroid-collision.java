class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>();
        
        list.add(asteroids[0]);
        
        for (int i=1; i<asteroids.length; i++) {
            if (asteroids[i] < 0) {
                boolean exploded = false;
                for (int j=list.size()-1; j >= 0; j--) {
                    if (list.get(j) < 0) { 
                        break;
                    } else if (list.get(j) < Math.abs(asteroids[i])) {
                        list.remove(j);
                    } else if (list.get(j) == Math.abs(asteroids[i])) {
                        exploded = true;
                        list.remove(j);
                        break;
                    } else {
                        exploded = true;
                        break;
                    }
                    
                    
                }
                if (!exploded) {
                        list.add(asteroids[i]);
                    }
            } else {
                list.add(asteroids[i]);
            }
        }
        
        int[] ans = new int[list.size()];
        
        for (int i=0; i<list.size(); i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}