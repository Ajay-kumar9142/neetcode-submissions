class MedianFinder {
    PriorityQueue<Integer> minpq;
    PriorityQueue<Integer> maxpq;

    public MedianFinder() {
       this.minpq = new PriorityQueue<>();
       this.maxpq = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
        maxpq.offer(num);
        if(maxpq.size()-minpq.size() > 1 || (!minpq.isEmpty() && maxpq.peek() > minpq.peek())){
          minpq.offer(maxpq.poll());
        }
        if(minpq.size() - maxpq.size() > 1){
            maxpq.offer(minpq.poll());
        }
    }
    
    public double findMedian() {
        if(minpq.size() == maxpq.size()){
            return (double)(maxpq.peek()+minpq.peek())/2;
        } else if(minpq.size() > maxpq.size()) return (double) minpq.peek();
        else return (double) maxpq.peek();
    }
}
