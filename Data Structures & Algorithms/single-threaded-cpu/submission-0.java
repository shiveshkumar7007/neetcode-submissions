class Solution {
    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;

        // [enqueueTime, processingTime, index]
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }

        // Sort by enqueue time
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        // Sort available tasks by:
        // 1. processing time
        // 2. index
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] != b[1]) {
                    return a[1] - b[1];
                }
                return a[2] - b[2];
            }
        );

        int[] result = new int[n];

        int index = 0;
        int resultIndex = 0;
        long time = 0;

        while (resultIndex < n) {

            // If no task is currently available,
            // jump time to the next task's enqueue time
            if (pq.isEmpty() && time < arr[index][0]) {
                time = arr[index][0];
            }

            // Add all tasks that are now available
            while (index < n && arr[index][0] <= time) {
                pq.offer(arr[index]);
                index++;
            }

            // Pick task with smallest processing time
            // If same, smallest index
            int[] task = pq.poll();

            result[resultIndex++] = task[2];

            // Process the task
            time += task[1];
        }

        return result;
    }
}