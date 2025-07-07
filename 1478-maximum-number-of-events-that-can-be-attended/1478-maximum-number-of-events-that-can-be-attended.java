class Solution {
    public int maxEvents(int[][] events) {
        // Step 1: Sort events by start day
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int day = 0, index = 0, res = 0, n = events.length;

        // Step 2: Iterate while there are events left or heap is not empty
        while (!minheap.isEmpty() || index < n) {
            // If heap is empty, move to the next available event's start day
            if (minheap.isEmpty()) {
                day = events[index][0];
            }

            // Add all events starting today to the heap
            while (index < n && events[index][0] == day) {
                minheap.offer(events[index][1]); // Add end day
                index++;
            }

            // Remove expired events
            while (!minheap.isEmpty() && minheap.peek() < day) {
                minheap.poll();
            }

            // Attend the event that ends earliest
            if (!minheap.isEmpty()) {
                minheap.poll();
                res++;
                day++;
            }
        }

        return res;
    }
}