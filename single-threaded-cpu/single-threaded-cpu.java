class Solution {
    public int[] getOrder(int[][] tasks) {
        Task [] taskArr = new Task[tasks.length];
        for (int i = 0; i< tasks.length; i++) {
            taskArr[i] = new Task(tasks[i][0], tasks[i][1], i);
        }
        Arrays.sort(taskArr, (t1, t2) -> t1.startTime - t2.startTime);
        Queue<Task> pq = new PriorityQueue<>(
            (t1, t2) -> {
                if (t1.processTime == t2.processTime) {
                    return t1.index - t2.index;
                }
                return t1.processTime - t2.processTime;
            });
        int currentTime = 0;
        int idx = 0;
        int taskIdx = 0;
        int [] result = new int[tasks.length];
        
        while (idx < result.length) {
            while (taskIdx < taskArr.length && taskArr[taskIdx].startTime <= currentTime) {
                pq.add(taskArr[taskIdx++]);
            }
            if (pq.size() == 0) {
                currentTime = taskArr[taskIdx].startTime;
                continue;
            }
            Task current = pq.poll();
            currentTime +=current.processTime;
            result[idx++] = current.index;
        }
        return result;
    }
}

class Task {
    int startTime;
    int processTime;
    int index;
    
    Task (int startTime, int processTime, int index) {
        this.startTime = startTime;
        this.processTime = processTime;
        this.index = index;
    }
}