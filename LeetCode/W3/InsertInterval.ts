function insert(intervals: number[][], newInterval: number[]): number[][] {

  let i = 0;

  //push intervals with [0] value less than newInterval
  while(i < intervals.length && intervals[i][1] < newInterval[0]) {
    i++;
  }

  while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
    newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
    newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
    intervals.splice(i,1)
    //i does not need increase, by removing element i
    //the next element would be placed in the same i and newIntervals recalculated
  }
  intervals.splice(i, 0, newInterval);

  
  return intervals;

};

// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]


//With a lot of input this solution faces runtime error

// function insert(intervals: number[][], newInterval: number[]): number[][] {

//   let result: number[][] = [];
//   let i = 0;

//   //push intervals with [0] value less than newInterval
//   while(i < intervals.length && intervals[i][1] < newInterval[0]) {
//     result.push(intervals[i]);
//     i++;
//   }

//   while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
//     newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
//     newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
//     i++;
//   }
//   result.push(newInterval);

//   while(i< intervals.length) {
//     result.push(intervals[i]);
//   }

//   return result;

// };
 
 
 
 //With an Interface definition
 
 //Define an interface to implement [0] and [1]
//   interface Interval {
//     [0]: number;
//     [1]: number;
//   }

// function insert(intervals: Interval[], newInterval: Interval): Interval[] {

//   let result: Interval[] = [];
//   let i = 0;

//   //push intervals with [0] value less than newInterval
//   while(i < intervals.length && intervals[i].[1] < newInterval.[0]) {
//     result.push(intervals[i]);
//     i++;
//   }

//   while(i < intervals.length && intervals[i].[0] >= newInterval.[1]) {
//     newInterval.[0] = Math.min(intervals[i].[0], newInterval.[0]);
//     newInterval.[1] = Math.max(intervals[i].[1], newInterval.[1]);
//     i++;
//   }
//   result.push(newInterval);

//   while(i< intervals.length) {
//     result.push(intervals[i]);
//   }



//   return result;

// };

// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]

//Solution: Greedy algorithm:  finding local optimal solutions with hope to get the global optimal solution.