class MedianFinder {
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;

    public MedianFinder() {
        maxheap = new PriorityQueue<>(Collections.reverseOrder());
        minheap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxheap.isEmpty() || maxheap.peek() >= num){
            maxheap.add(num);
        } else{
            minheap.add(num);
        }

        if(maxheap.size() > minheap.size() + 1){
            minheap.add(maxheap.poll());
        } else if(maxheap.size() < minheap.size()){
            maxheap.add(minheap.poll());
        }
    }
    
    public double findMedian() {
        if(maxheap.size() == minheap.size()){
            return (maxheap.peek() + minheap.peek()) / 2.0;
        }
        return maxheap.peek();
    }
}