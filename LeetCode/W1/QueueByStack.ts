class MyQueue {
  private q1;
  private q2;

  constructor() {
    this.q1  = [];
    this.q2 = [];
  }

  push(x: number): void {
    this.q1.push(x);
  }

  pop(): number {
    if (!this.q2.length) {
      while(this.q1.length) {
        this.q2.push(this.q1.pop())
      }
    }
    return this.q2.pop();
  }

  peek(): number {
    if (!this.q2.length) {
      while(this.q1.length) {
        this.q2.push(this.q1.pop())
      }
    }
    return this.q2[this.q2.length -1];
  }

  empty(): boolean {
    if (!this.q2.length && !this.q1.length) {
      return true;
    }
    return false;
  }
}

/**
* Your MyQueue object will be instantiated and called as such:
* var obj = new MyQueue()
* obj.push(x)
* var param_2 = obj.pop()
* var param_3 = obj.peek()
* var param_4 = obj.empty()
*/