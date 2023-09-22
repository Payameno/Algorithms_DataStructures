import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {

    //Maxheap - defined by Lambda expression as argument
    private Queue<Integer> MaxHeap = new PriorityQueue<>((a,b) -> b - a);

    //MinHeap
    private Queue<Integer> MinHeap = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {

      //Add the number to two heaps
      if (MaxHeap.isEmpty() || num <= MaxHeap.peek()) {
        MaxHeap.add(num);
      } else {
        MinHeap.add(num);
      }

      //Balance the heaps
      if (MinHeap.size() > MaxHeap.size()) {
        //.poll() in minHeap removes the min value
        Integer numb = MinHeap.poll();
        MaxHeap.add(numb);
      } else if (MaxHeap.size()> MinHeap.size() + 1) {
        //.poll() method in a maxHeap removes the max from the queue, time complexity (logn)
        Integer numb = MaxHeap.poll();
        MinHeap.add(numb);
      }
        
    }
    
    public double findMedian() {

      .peek() only retrives the max Value (O(1))

      if ((MaxHeap.size() + MinHeap.size()) % 2 != 0) return (double) MaxHeap.peek();

      return ((double) MaxHeap.peek() + (double) MinHeap.peek()) / 2;

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 * 
 * Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]


[1,2,3]

//Case1: Odd Numbers
maxHeap = [2,1]
minHeap = [3]
-> MaxHeap can be minHeap.size() + 1 or equal
MinHeap should be always less or equal in size with MaxHeap

//case 2: Even numbers
maxHeap = [2]
minHeap = [1]

Median would be a + b / 2


------- Time complexity

Since PriorityQueue is a binary heap data structure

Adding an element to the heap: O(logn)

Retrieving Max/Min without removing: constant O(1)

Removing Max/min O(Logn

Therefore the time complexity of addNum method is O(Logn)
Time complexity of findMedian: O(1) (.Peek retrieves the Max/min without removing it)
 */