// Definition for Node.

 class Node {
      val: number
      neighbors: Node[]
      constructor(val?: number, neighbors?: Node[]) {
          this.val = (val===undefined ? 0 : val)
          this.neighbors = (neighbors===undefined ? [] : neighbors)
      }
  }
 

// Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
// Output: [[2,4],[1,3],[2,4],[1,3]]

// Input: adjList = [[]]
// Output: [[]]

function cloneGraph(node: Node | null): Node | null {

 //solution:
 //define a map to keep track of visisted
 //define a queue to implement BFS 
 //loop through neiubours and recursively update the que and the map reference
 //return the reference to the root node, which contains clones of the values and neighbors

 if (!node) return null;

 const visited = new Map <number,Node>();
 const queue: Node[] = [node];
 visited.set(node.val, new Node(node.val));

 while(queue.length) {
  const newNode = queue.shift();
  const clonedNode = visited.get(newNode.val)!;

  for (const neighbor of newNode.neighbors) {

    if (!visited.has(neighbor.val)) {

      visited.set(neighbor.val, new Node(neighbor.val));
      queue.push(neighbor);
      
    }
    //populate neighbors for the current clone node
    clonedNode.neighbors.push(visited.get(neighbor.val)!);
  }
 }

return visited.get(node.val);
};