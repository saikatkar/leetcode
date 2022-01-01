class StockPrice {
    Map<Integer, Integer> priceMap = new HashMap<>();
    Queue<Stock> minHeap = new PriorityQueue<>(
        (s1, s2) -> s1.price - s2.price);
    Queue<Stock> maxHeap = new PriorityQueue<>(
        (s1, s2) -> s2.price - s1.price);
    int maxTime = 0;
    public StockPrice() {
        
    }
    
    public void update(int timestamp, int price) {
        priceMap.put(timestamp, price);
        maxHeap.add(new Stock(timestamp, price));
        minHeap.add(new Stock(timestamp, price));
        if (timestamp > maxTime) {
            maxTime = timestamp;
        }
    }
    
    public int current() {
        return priceMap.get(maxTime);
    }
    
    public int maximum() {
        while (priceMap.get(maxHeap.peek().timestamp) !=  maxHeap.peek().price) {
            maxHeap.poll();
        }
        return maxHeap.peek().price;
    }
    
    public int minimum() {
        while (priceMap.get(minHeap.peek().timestamp) !=  minHeap.peek().price) {
            minHeap.poll();
        }
        return minHeap.peek().price;
    }
}

class Stock {
    int timestamp;
    int price;
    
    Stock (int timestamp, int price) {
        this.timestamp = timestamp;
        this.price = price;
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