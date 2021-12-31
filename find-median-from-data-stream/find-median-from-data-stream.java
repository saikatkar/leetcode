class MedianFinder {
    Queue<Integer> minHeap = null;
    Queue<Integer> maxHeap = null;
    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if (!minHeap.isEmpty() && minHeap.peek() > num) {
            maxHeap.add(num);
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }
        } else {
            minHeap.add(num);
            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.add(minHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        double median = 0.0;
        if (minHeap.size() == maxHeap.size()) {
            median = (minHeap.peek() + maxHeap.peek())/2.0;
        }
        
        if (maxHeap.size() > minHeap.size()) {
            median = maxHeap.peek();
        }
        
        if (maxHeap.size() < minHeap.size()) {
            median = minHeap.peek();
        }
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */