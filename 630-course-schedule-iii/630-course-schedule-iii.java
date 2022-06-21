class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        Queue<Integer> heap = new PriorityQueue<>((a,b) -> b-a);
        int totalTime = 0;
        for (int[] c : courses) {
            if (totalTime + c[0] <= c[1]) {
                totalTime += c[0];
                heap.offer(c[0]);
            } else {
                if (!heap.isEmpty() && heap.peek() > c[0]) {
                    totalTime += c[0] - heap.poll();
                    heap.offer(c[0]);
                }
            }
        }
        return heap.size();
    }
}