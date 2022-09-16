class FileSystem {

    Map<String, Integer> map;
    public FileSystem() {
        map = new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
        String[] split = path.split("/");
        int n = split.length;
        
        System.out.println(Arrays.toString(split));
        if (n == 0) return false;
        
        String prefix = "";
        for (int i=1; i < n-1; i++) {
            prefix = prefix + "/" + split[i];
            System.out.println(prefix);
            if (!map.containsKey(prefix)) {
                return false;
            }
        }
        prefix = prefix + "/" + split[n-1];
        if (map.containsKey(prefix)) {
            return false;
        }
        
        map.put(prefix, value);
        return true;
        
    }
    
    public int get(String path) {
        String[] split = path.split("/");
        int n = split.length;
        if (n == 0) return -1;
        
        String prefix = "";
        for (int i=1; i<n-1; i++) {
            prefix = prefix + "/" + split[i];
            if (!map.containsKey(prefix)) {
                return -1;
            }
        }
        prefix = prefix + "/" + split[n-1];
        if (map.containsKey(prefix)) {
            return map.get(prefix);
        }
        
        return -1;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */