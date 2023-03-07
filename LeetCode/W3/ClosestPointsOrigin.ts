//Binary heap: constructor(node)
//methods of min binary heap: 1-enqueue 2- dequeue 3-swap 4-sinkdown 5-bubbleup  
//Node has(value, left, right)

// Input: points = [[3,3],[5,-1],[-2,4]], k = 2
// Input: points = [[3,3],[5,-1],[-2,4],[3,3],[5,-1]], k = 2
// Output: [[3,3],[-2,4]]


class MaxHeap {

  private heap: number[][] = [];

  construction(points: number[][]) {
    this.buildHeap(points);
  }

  buildHeap(points: number[][]):void {
    this.heap = points;
      for (let i = Math.floor(this.heap.length/2); i >=0; i--) {
      this.siftDown(i);
    }
  }

  private findParentindex(childIdx: number){
    return Math.floor(childIdx - 1 / 2);
  }

  private findLeftChildrenIndex(parentIdx: number){
    return parentIdx * 2 + 1;
  }

  private findRightChildrenIndex(parentIdx: number){
    return parentIdx * 2 + 2;
  }

  private siftUp(index: number){
    let parentIdx = this.findParentindex(index);

   while (index > 0 && this.distance(this.heap[index]) > this.distance(this.heap[parentIdx])) {
      this.swap(parentIdx, index);
      index = parentIdx ;
      parentIdx = this.findParentindex(index);
    }
  }

  private siftDown(index: number) :void {
    let maxIdx = index;
    let leftChildIdx = this.findLeftChildrenIndex(index);
    let rightChildIdx = this.findRightChildrenIndex(index);

    //if statement to check whethr distance of left children is lower or larger than parent
    if (leftChildIdx < this.heap.length && this.distance(this.heap[leftChildIdx]) > this.distance(this.heap[maxIdx])) {
      maxIdx = leftChildIdx;
    }

    //same for the right children
    if (rightChildIdx < this.heap.length && this.distance(this.heap[rightChildIdx]) > this.distance(this.heap[maxIdx])) {
      maxIdx = rightChildIdx;
    }

    if (index !== maxIdx) {
      this.swap(index, maxIdx);
      this.siftDown(index);
    }
  }

  private swap(idx1: number, idx2: number){
    [this.heap[idx1], this.heap[idx2]] = [this.heap[idx2], this.heap[idx1]]
  }

  private distance(point: number[]) {
    return point[0] ** 2 + point[1] ** 2;
  }

  public add(point: number[]):void {
    this.heap.push(point);
    this.siftUp(this.heap.length-1);
  }

  public removeMax(){
    const result = this.heap[0];
    this.heap[0] = this.heap[this.heap.length-1];
    this.heap.pop();
    this.siftDown(0);
    return result;
  }

}


function kClosest(points: number[][], k: number): number[][] {

  //a min binary heap class can be written
  // you can then dequeue from the heap for k times to acquire k closests points

}; 

