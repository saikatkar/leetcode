class TopVotedCandidate {
    int [] times;
    Map<Integer, Integer> map = new HashMap<>();
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        int lastLeader = 0;
        int newLeader = 0;
        int [] totalVote = new int[persons.length];
        for (int i = 0; i < times.length; i++) {
            totalVote[persons[i]]++;
            if (totalVote[persons[i]] >= totalVote[lastLeader]) {
                newLeader = persons[i];
            }
            map.put(times[i], newLeader);
            lastLeader = newLeader;
        }
        //System.out.println(map);
    }
    
    public int q(int t) {
        int time = binarySearch(times, 0, times.length-1, t);
        //System.out.println(time);
        return map.get(times[time]);
    }
    
    private int binarySearch (int [] times, int low, int high, int t)
    {
        while (low <= high) {
           int mid = low + (high-low)/2;
            if (times[mid] == t) {
                return mid;
            }
            else if (times[mid] < t) {
                low = mid + 1;
            } else if (times[mid] > t) {
                high = mid - 1;
            } 
        }
        return high;
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */