  //defining public properties shorthand for this.property in the constructor
  class QueueNode {
    constructor(public row: number, public col:number) {}
  }

function updateMatrix(mat: number[][]): number[][] {

  const rows: number = mat.length;
  const cols: number = mat[0].length;

  //create a quenode to capture positions of 0
  let queue: QueueNode[] = [];

  //output-> initialize with -1 for every position
  //-1 indicates not visited

  let outPut: number[][] = Array(rows).fill(null).map(() => Array(cols).fill(-1));

  //using the quenode change the property of output with 0 value to 0, to indicate visisted
    for (let row =0; row<rows; row++) {
      for (let col = 0; col<cols; col++) {
        if(mat[row][col] === 0) {
          queue.push(new QueueNode(row,col));
          outPut[row][col] = 0;
        }
      }
    };

  //write a BFS 
  while(queue.length>0) {

    const node = queue.shift() as QueueNode;
    const row = node.row;
    const col = node.col;
    const distance = outPut[row][col];
  //if valid, and -1, update value of output to 1, push the positions of it to the queue,
    //this position will be revisisted for checking neihboring nodes.
    for (const [r,c] of [[row+1,col],[row-1,col],[row,col+1],[row,col-1]]) {
      if(r>=0 && r < rows && c>=0 && c < cols && outPut[r][c] === -1) {
        outPut[r][c] = distance + 1;
        queue.push(new QueueNode(r,c));
      }
    }

  }

  return outPut;
};


// 0 -- 0 -- 0
// |    |    |
// 0 -- 1 -- 0
// |    |    |
// 1 -- 1 -- 1    

//output
// 0 --  0 -- 0
// |     |    |
// 0 -- -1 -- 0
// |     |    |
// -1 -- -1 -- -1    

// class QueueNode {
//   constructor(public row: number, public col: number) {}
// }

// function updateMatrix(matrix: number[][]): number[][] {
//   const rows = matrix.length;
//   const cols = matrix[0].length;

//   // Initialize the output matrix with -1s (unvisited)
//   const output: number[][] = Array(rows)
//     .fill(null)
//     .map(() => Array(cols).fill(-1));

//   // Create a queue to hold the nodes to be visited
//   const queue: QueueNode[] = [];

//   // Add all the 0s to the queue and mark them as visited
//   for (let row = 0; row < rows; row++) {
//     for (let col = 0; col < cols; col++) {
//       if (matrix[row][col] === 0) {
//         queue.push(new QueueNode(row, col));
//         output[row][col] = 0;
//       }
//     }
//   }

//   // BFS to find the nearest 0 for all the unvisited nodes
//   while (queue.length > 0) {
//     const node = queue.shift() as QueueNode;
//     const row = node.row;
//     const col = node.col;
//     const distance = output[row][col] + 1;

//     // Check the adjacent nodes
//     for (const [r, c] of [[row - 1, col], [row, col + 1], [row + 1, col], [row, col - 1]]) {
//       if (r >= 0 && r < rows && c >= 0 && c < cols && output[r][c] === -1) {
//         // This node is unvisited, mark it as visited and add it to the queue
//         output[r][c] = distance;
//         queue.push(new QueueNode(r, c));
//       }
//     }
//   }

//   return output;
// }