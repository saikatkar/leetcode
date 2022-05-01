class FrontMiddleBackQueue {
    LinkedList<Integer> queue;
    
    public FrontMiddleBackQueue() {
        queue = new LinkedList<>();
    }
    
    public void pushFront(int val) {
        queue.addFirst(val);
    }
    
    public void pushMiddle(int val) {
        int size = queue.size();
        int m = size/2;
        queue.add(m, val);
                System.out.println(queue);

    }
    
    public void pushBack(int val) {
        queue.addLast(val);
    }
    
    public int popFront() {
        if (!queue.isEmpty()) {
            return queue.removeFirst();    
        }
        return -1;
    }
    
    public int popMiddle() {
        if (queue.isEmpty()) {
            return -1;
        }
        int size = queue.size()-1;
        int m = size/2;
        return queue.remove(m);
    }
    
    public int popBack() {
        if (!queue.isEmpty()) {
           return queue.removeLast(); 
        }
        return -1;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */