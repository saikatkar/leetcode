class SeatManager {
    Queue<Integer> minHeap = null;
    int number = 0;
    public SeatManager(int n) {
        minHeap = new PriorityQueue<>();
        minHeap.add(1);
    }
    
    public int reserve() {
        int reserve = minHeap.poll();
        if (minHeap.isEmpty()) {
            minHeap.add(reserve+1);
        }
        return reserve;
    }
    
    public void unreserve(int seatNumber) {
        minHeap.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */