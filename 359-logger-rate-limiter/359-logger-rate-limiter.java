class Logger {
    Map<String, Integer> lastPrintMessageTimeMap;
    public Logger() {
        lastPrintMessageTimeMap = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (lastPrintMessageTimeMap.containsKey(message)) {
            int lastPrintTime = lastPrintMessageTimeMap.get(message);
            if (timestamp - lastPrintTime < 10) {
                return false;
            }
            lastPrintMessageTimeMap.put(message, timestamp);
            return true;
        }
        
        lastPrintMessageTimeMap.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */