class StockPrice {
    TreeMap<Integer, Integer> priceToTimeStampsCount;
    Map<Integer, Integer> timeStampToStockPrice;
    
    int latestTimeStamp;
    
    public StockPrice() {
        priceToTimeStampsCount = new TreeMap<>();
        timeStampToStockPrice = new HashMap<>();
        latestTimeStamp = 0;
    }
    
    public void update(int timestamp, int price) {
        if (timeStampToStockPrice.containsKey(timestamp)) {
            int currentPrice = timeStampToStockPrice.get(timestamp);
            priceToTimeStampsCount.put(currentPrice, priceToTimeStampsCount.get(currentPrice)-1);
            if (priceToTimeStampsCount.get(currentPrice) == 0) {
                priceToTimeStampsCount.remove(currentPrice);
            }
        }
        
        timeStampToStockPrice.put(timestamp, price);
        priceToTimeStampsCount.put(price, priceToTimeStampsCount.getOrDefault(price, 0) + 1);
        
        latestTimeStamp = Math.max(latestTimeStamp, timestamp);
    }
    
    public int current() {
        return timeStampToStockPrice.get(latestTimeStamp);
    }
    
    public int maximum() {
        return priceToTimeStampsCount.lastKey();
    }
    
    public int minimum() {
        return priceToTimeStampsCount.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */