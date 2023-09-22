class solution1 {

    //Define the binaryHeap data structures
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    //Overal size of all nums added to both data structures
    int size;


    public MedianFinder() {

        //Initiating the data structures
        minHeap = new PriorityQueue<>(); //By default min heap
        maxHeap = new PriorityQueue<>((a,b) -> b - a); //lambda expression to set as maxHeap
        size = 0;
        
    }
    
    public void addNum(int num) {
        
        //Decide whether adding to min or max
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
            size++;
        } else {
            minHeap.add(num);
            size++;
        }

        //Balance both heaps to be different by no more than 1 element in size (MaxHeap will be 1 element larger if odd)
        if (minHeap.size() + 1 < maxHeap.size()) {
            //(logn) time complexity to remove
            //.pol() method in a maxHeap removes the max from the queue, time complexity (logn)
            Integer el = maxHeap.poll();
            minHeap.add(el);
        } else if (maxHeap.size() < minHeap.size()) {
            //.poll() in minHeap removes the min value
            Integer el = minHeap.poll();
            maxHeap.add(el);  
        }
    }
    
    public double findMedian() {

        //If size is odd
        if (size % 2 != 0) {

            /*
            1,2,3,4,5
            maxHeap = [< 3 >,2,1]
            minHeap = [4,5]
            .peek() only retrives the max Value (O(1))
            */
            return (double) maxHeap.peek();

        } 

         //if even
        return (double) (minHeap.peek() + maxHeap.peek())/ 2; 
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */